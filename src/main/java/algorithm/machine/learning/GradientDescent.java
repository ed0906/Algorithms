package algorithm.machine.learning;

import algorithm.matrix.Matrix;
import algorithm.matrix.MatrixDimensionException;

public abstract class GradientDescent {

	protected Matrix x;
	protected Matrix y;
	
	protected GradientDescent(Matrix x, Matrix y) {
		if(x == null || y == null || x.rowCount() != y.rowCount() || y.columnCount() != 1){
			throw new MatrixDimensionException("Matrices X & Y must be the same size and Y must be a column vector");
		}
		
		this.x = prependX0(x);
		this.y = y;
	}
	
	public abstract double iterate();
	
	protected Matrix prependX0(Matrix rawX) {
		Matrix x = new Matrix(rawX.rowCount(), rawX.columnCount() + 1);
		x.fill(0, rawX.rowCount()-1, 0, 0, 1);
		return x.setSubMatrix(0, 1, rawX);
	}
}
