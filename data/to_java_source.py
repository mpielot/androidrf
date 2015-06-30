# ======================================================================================
#
# This script create a Java source code file with a working, Random Forest classifier.
# To run, it solely requires two additinal Java classes bundles with this repository.
#
# It creates the file from the output console of WEKA. To generate the output that this
# script can process, follow these steps:
#
# (1) Load your data into WEKA, go to 'Classify', and choose Random Forest as classifier
# (2) Enable the 'printTrees' option of the classifier
# (3) Copy *the whole* output of the 'Classifier output' window into a .txt file
#
# Then, run the script with
#
# python to_java_source name_of_your_txt_file.txt
#
# The classifier will be created in src/org/pielot/rf. It will be named after the 
# text file.
#
#
# Author:       Martin Pielot
# Date:         June 30, 2015
# Version:      1
# Copyright:    MIT Licence
#
# ======================================================================================

import sys
import argparse



DEBUG = False # this will write debug code into the output. Don't use!

PACKAGE_NAME = "org.pielot.rf"
SOURCE_FOLDER = "../src/org/pielot/rf/"
EXAMPLE_CLASSIFIER = "phonecalls"



#Command line arguments
parser = argparse.ArgumentParser(description='Script for converting WEKA \'printtree\' output of Random Forests into source code')
parser.add_argument('-M','--model', default=EXAMPLE_CLASSIFIER, help='output of WEKA\'s \'Save result buffer\'')
# parser.add_argument('-J','--java', default=EXAMPLE_CLASSIFIER, help='name of the Java class to generate')

args = parser.parse_args()


input_file_name = args.model
classifier_class_name = args.model.title()


# counter used to run through the output lines of a tree
tree_list_index = -1
# dictionary to store each variable and its type
var_dict = {}
# dictionary to store each class
classes_dict = {}

# masks the condition, e.g. it changes var = value to var.equals(value)
def mask(condition):

    global var_dict
    space_index = condition.index(' ')
    var = condition[0: space_index]

    if ' = ' in condition:
        equal_index = condition.index(' = ')
        variable = condition[0: equal_index].strip()
        value = '' + condition[equal_index+3: ].strip()

        var_dict[var] = 'String'

        # this order avoids NullPointerExceptions
        return '\"' + value + '\".equals(' + variable + ')'

    var_dict[var] = 'double'

    return condition


# converts the leaf into a Java response, e.g. Baseline (122/8) --> "Baseline"
def to_leaf(leaf):

    space_index = leaf.index(' ')
    parenthesis_open = leaf.index('(')
    slash = leaf.index('/')
    parenthesis_close = leaf.index(')')

    leaf_class = leaf[0: space_index]

    num_pos = leaf[parenthesis_open + 1: slash]
    num_neg = leaf[slash + 1: parenthesis_close]


    classes_dict[leaf] = 1

    return leaf_class, num_pos, num_neg


def print_if_then_statements(node_list):

    for condition, next_node in node_list.iteritems():
        # print condition

        if type(next_node) == dict:
            print '\tif( %s ) { ' % (condition)
            print_if_then_statements (next_node)
            print '\t}'

        else:
            leaf, num_pos, num_neg = to_leaf(next_node)
            print '\t\tif( %s ) { return new Prediction(\"%s\", %s, %s); }' % (condition, leaf, num_pos, num_neg)


def print_variables():

    # print 'public String MyClass;'
    for var_name, var_type in var_dict.iteritems():
        print 'public %s %s;' % (var_type, var_name)


def print_tostring():

    print 'public String toString() {' 
    print 'StringBuilder b = new StringBuilder();'
    print 'b.append(\"MyClass: \");'
    print 'b.append(MyClass);'
    for var_name, var_type in var_dict.iteritems():
        print 'b.append(\", %s: \");' % var_name
        print 'b.append(%s);' % var_name

    print 'return b.toString();'
    print '}'


def print_tree_method(node_list, tree_id):


    print 'private Prediction runTree%d() {' % tree_id
    print_if_then_statements(node_list)
    print 'return null;'
    print '}'


def print_run_all_predictions_method(trees):

    print 'protected void runClassifiers(List<Prediction> predictions) {'
    tree_id = 0
    for tree in trees:
        print '\tpredictions.add(runTree%s());' % tree_id
        tree_id += 1

    print '}'


def print_trees(trees):

    print ''
    print 'package %s;' %PACKAGE_NAME
    print ''
    print 'import java.util.List;'
    print ''
    print 'public class %sRandomForest extends RandomForest {' % classifier_class_name

    print ''
    print_variables()
    print ''
    print_tostring()
    print ''
    print_run_all_predictions_method(trees)
    print ''

    tree_id = 0
    for tree in trees:
        print_tree_method(tree, tree_id)
        tree_id += 1

    print '}'
    print ''




def extract_tree(node_list, tree_lines, depth = 0):

    global tree_list_index

    while tree_list_index + 1 < len(tree_lines):
    
        tree_list_index += 1
        tree_line = tree_lines[tree_list_index]
        level = tree_line.count('|')
        line = tree_line.replace('|', '')

        #print tree_list_index, depth, level, tree_line

        if depth == level:

            # determine index of ':' and remove it + everthing that follows
            if ':' in line:
                #print 'leaf'
                colon_index = line.index(':')
                leaf = '' + line[colon_index+1: ].strip()
                condition = mask(line[0: colon_index].strip())

                #print '\tif( %s ) { return \"%s\"; }' % (condition, leaf)

                node_list[condition] = leaf

            else:
                #print 'subtree'
                condition = mask(line.strip())
                sub_node_list = {}
                #print 'if( %s ) { ' % (condition)
                extract_tree(sub_node_list, tree_lines, depth = level + 1)
                node_list[condition] = sub_node_list
                #print '}'

        elif depth > level:
            tree_list_index -= 1
            #print 'jump back to %d' % tree_list_index
            return






def main(buffer_file):
  with open(buffer_file, 'rU') as f:

        global tree_list_index
        try:

            still_more_trees = True
            tree_found = False
            tree_index = -1

            trees = []

            while still_more_trees:

                # read until 'RandomTree' text or end of trees
                line = ""
                while still_more_trees:
                    line = f.readline().strip()
                    if line == 'RandomTree':
                        tree_index += 1
                        tree_found = True
                        break

                    if line == '=== Summary ===':
                        still_more_trees = False
                        print ''

                if still_more_trees:
                    # skip two lines until tree starts
                    line = f.readline()
                    line = f.readline()

                    
                    # now read until next while space = when tree stops
                    line = f.readline().strip()
                    tree_lines = []
                    while len(line) > 0:
                        tree_lines.append(line)
                        line = f.readline().strip()

                    if DEBUG: print tree_lines
                    if DEBUG: print '-------------------------'

                    node_list = {}
                    tree_list_index = -1
                    extract_tree(node_list, tree_lines)
                    trees.append(node_list)
                    if DEBUG: print node_list
                    if DEBUG: print '========================='
                    
                    #print_tree_method(node_list, tree_index)

            print_trees(trees)

        except KeyboardInterrupt:
            print "Keyboard interrupt! Halting script"
            exit()

        except SystemExit:
            print "SystemExit! Halting script"
            exit()

        except:
            e = sys.exc_info()[0]
            msg = sys.exc_info()[1]
            print 'exception: %s: %s' % (e, msg)
            raise




# main
# -------------------------------------------------------
if __name__ == '__main__':
    input_file = input_file_name+".txt"
    output_file = SOURCE_FOLDER + classifier_class_name + "RandomForest.java"

    print "Converting Result buffer from '%s' into '%s'" % (input_file, output_file)

    orig_stdout = sys.stdout
    f = file(output_file, 'w')
    sys.stdout = f

    main(input_file)

    sys.stdout = orig_stdout
    f.close()

