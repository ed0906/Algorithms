package algorithm.machine.learning;

import algorithm.machine.learning.hypothesis.Hypothesis;
import algorithm.machine.learning.hypothesis.RegressionHypothesis;
import algorithm.matrix.Matrix;
import algorithm.matrix.MatrixDimensionException;

public class GradientDescent {

	private final static int ITERATIONS = 100;
	private double ALPHA = 0.1;
	private Hypothesis hypothesis;
	private Matrix x;
	private Matrix y;
	
	public GradientDescent(final Matrix x, final Matrix y){
		if(x == null || y == null || x.columnCount() != y.columnCount() || y.rowCount() != 1){
			throw new MatrixDimensionException("Matrices X & Y must be the same size and y must be a row vector");
		}
		
		this.x = x;
		this.y = y;
		this.hypothesis = new RegressionHypothesis(x.rowCount());
	}
	
	public Hypothesis getHypothesis() {
		return this.hypothesis;
	}
	
	public Hypothesis getMinimizedHypothesis() {
		int n = 0;
		while(n < ITERATIONS) {
			iterate();
		}
		return hypothesis;
	}
	
	public void iterate() {
		Matrix h = hypothesis.calculate(x);
		Matrix theta1 = hypothesis.getWeights();
		
		Matrix theta2 = theta1.copy();
		for(int r=0; r<theta1.rowCount()-1; r++){
			Matrix dCost = h.subtract(y).toPowerOf(2).multiplyElementsBy(x.subMatrix(r, r, 0, x.columnCount()-1));
			double diff = dCost.sum();
			theta2.set(r, 0, theta1.get(r, 0) - ALPHA * diff);
		}

		hypothesis = new RegressionHypothesis(theta2);
	}
}
