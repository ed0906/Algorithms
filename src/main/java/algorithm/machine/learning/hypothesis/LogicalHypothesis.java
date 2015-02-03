package algorithm.machine.learning.hypothesis;

import algorithm.matrix.Matrix;
import algorithm.matrix.MatrixDimensionException;
import algorithm.matrix.MatrixElementFunction;

public class LogicalHypothesis extends Hypothesis {
	
	private static MatrixElementFunction sigmoid;
	
	public LogicalHypothesis(Matrix theta) {
		super(theta);
	}
	
	public LogicalHypothesis(int seriesCount) {
		super(seriesCount);
	}

	@Override
	public Matrix evaluate(Matrix x) {
		return sigmoid(x.multiplyBy(theta));
	}
	
	private Matrix sigmoid(Matrix input) {
		if(input.columnCount() != 1) {
			throw new MatrixDimensionException("Input matrix must be a column vector, instead had dimensions (" + input.rowCount() + "," + input.columnCount() + ")");
		}
		if(sigmoid == null) {
			sigmoid = new MatrixElementFunction(){
				@Override
				public double applyFunction(double element) {
					double denom = 1 + Math.exp(-element);
					if(denom != 0) {
						return 1d / denom;
					}
					return 0;
				}
			};
		}
		return sigmoid.evaluate(input);
	}
}
