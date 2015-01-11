package algorithm.machine.learning.hypothesis;

import algorithm.matrix.Matrix;

public class RegressionHypothesis extends Hypothesis {
	
	public RegressionHypothesis(Matrix theta) {
		super(theta);
	}
	
	public RegressionHypothesis(int seriesCount) {
		super(seriesCount);
	}

	@Override
	public Matrix calculate(Matrix x) {
		return theta.transpose().multiplyBy(x);
	}

}
