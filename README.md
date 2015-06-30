# androidrf
Export Random Forests from WEKA's console output into java source code - ideal for Android

If you are using WEKA and your looking for a way to create executable Java source could from a Random Forest model, this project is for you.

In a nutshell, it takes WEKA' console output of the RandomForest classifier (with -printTree) enabled, and parses it into a Java source file. The project contains three other Java source files that allow to run and test the classifier. This allows to create a simple, light-weight, portable Random Forest model for Java-enabled platforms.

Background: for my research, I was running classifiers on Android phones. Random Forests turned out to be the best-performing classifiers for most of my projects. To run the classifiers on the phone, I used the quite bulky WEKA for Android. Because for some reason the model im- and export functions failed when distributing pre-computed models across devices, I ended up with my applications creating the classifiers from scratch at each starts. This usually takes several minutes and is resource-intensive.

With this solution, you can create the  models on a potent desktop computer once, and ship the pre-computed model in source code form with the code of your application.
