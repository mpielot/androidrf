package org.pielot.rf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;

/**
 * This class allows a basic evaluation of a classifier's performance
 * 
 * @author Martin Pielot
 * @version June 30, 2015
 */
public class Evaluate {

	/**
	 * Run an evaluation of the given classifier with the given test-data set. The method uses Java reflection to
	 * populate the fields of the Random Forest implementation with the data from the input CSV file. You have to make
	 * sure that for each entry in the CSV file there is a field in the Random Forest implementation. If the Random
	 * Forest class has been generated from the CSV file, it should work without problem.
	 * 
	 * @param rf the Random Forest classifier to be tested
	 * @param testData the test data set in .csv format
	 * @throws Exception
	 */
	private static void evalClassifier(RandomForest rf, File testData) throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader(testData));

		// Read and store the names of the features
		String headerLine = reader.readLine();
		String[] featureNames = headerLine.split(",");

		String line = null;
		int numTotal = 0;
		int numCorrect = 0;
		boolean correct = false;

		// Iterate through features
		while ((line = reader.readLine()) != null) {

			String[] featureValues = line.split(",");

			// Populate the fields of the classifier from the CSV data via reflection
			setFields(rf, featureNames, featureValues);

			// Run the classifier
			correct = classifyInstance(rf);

			// Keep track of number of (correct) tests
			if (correct) {
				numCorrect++;
			}
			numTotal++;

			// Compute accuracy (but only keep for digits after comma)
			int accInt = 10000 * numCorrect / numTotal;
			double acc = accInt / 10000.0;
			System.out.println(numTotal + ": accuracy: " + acc);
		}
		reader.close();

		// Compute TOTAL accuracy (but only keep for digits after comma)
		int accInt = 10000 * numCorrect / numTotal;
		double acc = accInt / 10000.0;
		System.out.println("final accuracy: " + acc);
	}

	/**
	 * This method uses Java reflection to populate the fields of the Random Forest implementation from the two given
	 * String-Arrays, where one array contains the field names and the other the values.
	 * 
	 * @param rf Random Forest implementation
	 * @param featureNames array with names of the features
	 * @param featureValues array with values of the features - in same order as #featureNames
	 */
	private static void setFields(RandomForest rf, String[] featureNames, String[] featureValues) {

		String featureName = null;
		String featureValue = null;

		// Iterate through all the pairs of feature names and values
		for (int i = 0; i < featureNames.length; i++) {
			featureName = featureNames[i];
			featureValue = featureValues[i];

			// If value is not missing
			if (featureValue.length() > 0) {
				try {
					try {
						try {

							// try interpret the feature as numeric value
							if (featureValue.length() > 0) {
								double featureValueDouble = Double.parseDouble(featureValue);
								setDoubleField(rf, featureName, featureValueDouble);
							}

						} catch (NumberFormatException e) {

							// in case that fails, try to interpret the feature as String
							setStringField(rf, featureName, featureValue);
						}

					} catch (NoSuchFieldException nsfe) {

						// in case the field is not recognized, this is the ground truth
						rf.MyClass = featureValue;
					}

				} catch (Exception e) {
					System.err.println("featureName: " + featureName + "', featureValue: '" + featureValue + "'");
					e.printStackTrace();
					System.exit(1);
				}
			}
		}
	}

	/**
	 * Runs the classification
	 * 
	 * @param rf Random Forest implementation with populated fields
	 * @return whether the classification was correct
	 */
	private static boolean classifyInstance(RandomForest rf) {
		String actualClass = rf.MyClass;

		// If actual class is NULL, end with error - this should not happen
		if (actualClass == null) {
			System.err.println("NO GROUND TRUTH");
			System.exit(1);
			return false;
		}

		// run actual classification
		Prediction p = rf.runClassification();
		String predClass = p.label;

		// compare whether actual and predicted labels match and return result
		boolean correct = actualClass.equals(predClass);
		return correct;
	}

	/**
	 * Uses reflection to set a double field to the given value
	 * 
	 * @param rf Random Forest implementation
	 * @param fieldName the name of the specified field
	 * @param value the value that this field shall take
	 * @throws NoSuchFieldException if Random Forest implementation does not contain the specified field
	 */
	private static void setDoubleField(RandomForest rf, String fieldName, double value) throws NoSuchFieldException,
			IllegalAccessException {
		Field field = rf.getClass().getDeclaredField(fieldName);
		field.setDouble(rf, value);
	}

	/**
	 * Uses reflection to set a String field to the given value
	 * 
	 * @param rf Random Forest implementation
	 * @param fieldName the name of the specified field
	 * @param value the value that this field shall take
	 * @throws NoSuchFieldException if Random Forest implementation does not contain the specified field
	 */
	private static void setStringField(RandomForest rf, String fieldName, String value) throws NoSuchFieldException,
			IllegalAccessException {
		Field field = rf.getClass().getDeclaredField(fieldName);
		field.set(rf, value);
	}

	/**
	 * Main method that starts the evaluation of the 'phonecalls' data set that was shipped as example.
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) throws Exception {
		RandomForest rf = new PhonecallsRandomForest();

		File testData = new File("data/phonecalls.csv");
		boolean exists = testData.exists();
		System.out.println(testData.getAbsolutePath() + ", exists == " + exists);

		evalClassifier(rf, testData);
	}

}
