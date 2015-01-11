package algorithm.machine.learning.hypothesis;

import algorithm.matrix.Matrix;
import algorithm.matrix.MatrixDimensionException;

public abstract class Hypothesis {
	
	protected Matrix theta;
	
	protected Hypothesis(Matrix theta) {
		if(theta.rowCount() > 1) {
			throw new MatrixDimensionException("Theta must be a column vector");
		}
		this.theta = theta;
	}
	
	protected Hypothesis(int seriesCount) {
		theta = new Matrix(seriesCount, 1);
	}
	
	public Matrix getWeights() {
		return this.theta;
	}

	public abstract Matrix calculate(final Matrix x);
	
	public int getSeriesCount() {
		return theta.columnCount();
	}
}
