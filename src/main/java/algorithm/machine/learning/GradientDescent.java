package algorithm.machine.learning;

import algorithm.machine.learning.hypothesis.Hypothesis;
import algorithm.matrix.Matrix;
import algorithm.matrix.MatrixDimensionException;

public abstract class GradientDescent {

	private final static int ITERATIONS = 100;
	private final static double SMALL_CHANGE = 0.01;
	protected Matrix x;
	protected Matrix y;
	protected double ALPHA = 0.1;
	protected Hypothesis hypothesis;
	private double lastJ;
	
	protected GradientDescent(Matrix x, Matrix y, Hypothesis hypothesis) {
		if(x == null || y == null || x.rowCount() != y.rowCount() || y.columnCount() != 1){
			throw new MatrixDimensionException("Matrices X & Y must be the same size and Y must be a column vector");
		}
		
		this.x = prependX0(x);
		this.y = y;
		this.hypothesis = hypothesis;
		this.lastJ = Double.MAX_VALUE;
	}
	
	public abstract double iterate();
	
	protected Matrix prependX0(Matrix rawX) {
		Matrix x = new Matrix(rawX.rowCount(), rawX.columnCount() + 1);
		x.fill(0, rawX.rowCount()-1, 0, 0, 1);
		return x.setSubMatrix(0, 1, rawX);
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
}
