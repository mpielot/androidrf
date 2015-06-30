package org.pielot.rf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class implements the basic structure of the Random Forests. It contains methods to run the classification.
 * 
 * @author Martin Pielot
 * @version June 30, 2015
 */
public abstract class RandomForest {
	
	public String MyClass;

	/**
	 * Flag that decides the voting strategy: when false, the class is decided by a simple majority vote; when true, the
	 * decision takes the number of positive leafs returned by each tree into account. True by default.
	 */
	public static boolean	use_votes	= true;

	/** Runs the classification. The features have to be set by updating the fields of the implementing class. */
	public Prediction runClassification() {

		// Runs the classifier and stores each classifiers vote into an array
		List<Prediction> predictions = new ArrayList<Prediction>();
		runClassifiers(predictions);

		// Count the number of votes and leafs for each label
		Map<String, Integer> winners = new HashMap<String, Integer>();
		Map<String, Integer> votes = new HashMap<String, Integer>();
		int totalVotes = 0;
		for (Prediction prediction : predictions) {
			if (prediction != null) {
				inc(winners, prediction.label, 1);
				inc(votes, prediction.label, prediction.numPos);
				totalVotes += prediction.getNumLeafs();
			}
		}

		// Determine the label with the highest vote count
		String winner = winner(use_votes ? votes : winners);
		int numPosVotes = votes.get(winner);
		int numNegVotes = totalVotes - numPosVotes;

		// Create prediction object from the results and return as final result
		Prediction result = new Prediction(winner, numPosVotes, numNegVotes);
		return result;
	}

	/**
	 * Determines the winner from the given votes
	 * 
	 * @param votes the list with the number of votes for each label
	 * @return the label with the highest number of votes
	 */
	private String winner(Map<String, Integer> votes) {
		String winner = "";
		int maxVotes = 0;

		for (String label : votes.keySet()) {
			int voteCount = votes.get(label);
			if (voteCount > maxVotes) {
				winner = label;
				maxVotes = voteCount;
			}
		}

		return winner;
	}

	/**
	 * Increases the votes for the given classifier by the given number
	 * 
	 * @param votes Map containing the votes for each label
	 * @param label the label to which the votes shall be added
	 * @param voteCount the number of votes to add
	 */
	private void inc(Map<String, Integer> votes, String label, int voteCount) {
		int count = 0;
		if (votes.containsKey(label)) {
			count = votes.get(label);
		}
		votes.put(label, count + voteCount);
	}

	/**
	 * Tells the implementing class to run the classification
	 * 
	 * @param predictions a list in which the classifier will store the predictions of each individual tree.
	 */
	protected abstract void runClassifiers(List<Prediction> predictions);

}
