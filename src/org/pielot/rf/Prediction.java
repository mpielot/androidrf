package org.pielot.rf;

/**
 * This class encapsulates the prediction returned by the Random Forest classifier
 * 
 * @author Martin Pielot
 * @version June 30, 2015
 */
public class Prediction {

	/** The class label of the prediction, e.g. 'picked' */
	public String	label;
	/** The number of votes FOR this label */
	public int		numPos;
	/** The number of votes for OTHER labels */
	public int		numNeg;
	/** The total number of votes */
	public int		total;
	/** Probability - how certain the classifier is that the prediction is correct */
	public double	p;

	/**
	 * Creates a new instance of a Prediction object
	 * 
	 * @param label The class label of the prediction, e.g. 'picked'
	 * @param numPos The number of votes FOR this label
	 * @param numNeg The number of votes for OTHER labels
	 */
	public Prediction(String label, double numPos, double numNeg) {
		this.label = label;
		this.numPos = (int) (numPos + 0.5);
		this.numNeg = (int) (numNeg + 0.5);
		this.total = this.numPos + this.numNeg;
		this.p = getProbability();
	}

	/** Probability - how certain the classifier is that the prediction is correct */
	private double getProbability() {
		if (total == 0) return 0;
		int c = 10000;
		double p = c * numPos / total;
		return p / c;
	}

	/** The total number of votes */
	public int getNumLeafs() {
		return total;
	}

	/** Creates a human-readable representation of this prediction - useful for debugging */
	@Override
	public String toString() {
		return label + ", \tp: " + p + ", \t( " + numPos + " / " + numNeg + " )";
	}

}
