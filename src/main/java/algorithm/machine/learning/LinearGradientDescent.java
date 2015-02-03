package algorithm.machine.learning;

import algorithm.machine.learning.hypothesis.Hypothesis;
import algorithm.machine.learning.hypothesis.RegressionHypothesis;
import algorithm.matrix.Matrix;

public class LinearGradientDescent extends GradientDescent{

	private final static int ITERATIONS = 100;
	private final static double SMALL_CHANGE = 0.01;
	private double ALPHA = 0.1;
	private Hypothesis hypothesis;
	private double lastJ;
	
	public LinearGradientDescent(final Matrix x, final Matrix y){
		super(x,y);
		this.hypothesis = new RegressionHypothesis(this.x.columnCount());
		this.lastJ = Double.MAX_VALUE;
	}
	
	public Hypothesis getHypothesis() {
		return this.hypothesis;
	}
	
	public Hypothesis getMinimizedHypothesis() {
		int n = 0;
		boolean repeat = true;
		double j;
		while(repeat) {
			j = iterate();
			n++;
			
			if(n > ITERATIONS) {
				repeat = false;
			} else if(lastJ-j < SMALL_CHANGE) {
				if(lastJ-j > 0) {
					ALPHA *= 0.8;
				} else{
					repeat = false;
				}
			}
			lastJ = j;
		}
		return hypothesis;
	}
	
	public double iterate() {
		Matrix h = hypothesis.evaluate(x); // Hypothesis
		Matrix theta = hypothesis.getWeights();
		Matrix residual = h.subtract(y);
		
		Matrix jDifferential = x.transpose().multiplyBy(residual); // d(j)/dTheta
		
		theta = theta.subtract(jDifferential.multiplyBy(ALPHA)); // Adjusted theta
		hypothesis = new RegressionHypothesis(theta);
		
		return residual.transpose().multiplyBy(residual).get(0, 0); // Cost Function
	}
}
