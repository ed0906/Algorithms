package algorithm.machine.learning;

import algorithm.machine.learning.hypothesis.RegressionHypothesis;
import algorithm.matrix.Matrix;

public class LinearGradientDescent extends GradientDescent{
	
	public LinearGradientDescent(final Matrix x, final Matrix y){
		super(x,y, new RegressionHypothesis(x.columnCount()+1));
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
