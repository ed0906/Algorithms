package algorithm.machine.learning;

import algorithm.machine.learning.hypothesis.Hypothesis;
import algorithm.machine.learning.hypothesis.RegressionHypothesis;
import algorithm.matrix.Matrix;
import algorithm.matrix.MatrixDimensionException;

public class GradientDescent {

	private final static int ITERATIONS = 100;
	private final static double SMALL_CHANGE = 0.01;
	private double ALPHA = 0.1;
	private Hypothesis hypothesis;
	private Matrix x;
	private Matrix y;
	private double lastJ;
	
	public GradientDescent(final Matrix x, final Matrix y){
		if(x == null || y == null || x.rowCount() != y.rowCount() || y.columnCount() != 1){
			throw new MatrixDimensionException("Matrices X & Y must be the same size and Y must be a column vector");
		}
		
		this.x = generateX(x);
		this.y = y;
		this.hypothesis = new RegressionHypothesis(this.x.columnCount());
		this.lastJ = Double.MAX_VALUE;
	}
	
	private Matrix generateX(Matrix rawX) {
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
