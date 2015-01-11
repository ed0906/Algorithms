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
	public Matrix evaluate(Matrix x) {
		return x.multiplyBy(theta);
	}

}
