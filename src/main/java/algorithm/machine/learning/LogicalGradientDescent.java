package algorithm.machine.learning;

import algorithm.machine.learning.hypothesis.Hypothesis;
import algorithm.machine.learning.hypothesis.LogicalHypothesis;
import algorithm.matrix.Matrix;
import algorithm.matrix.MatrixElementFunction;

public class LogicalGradientDescent extends GradientDescent {

	private MatrixElementFunction log;

	public LogicalGradientDescent(final Matrix x, final Matrix y) {
		super(x, y, new LogicalHypothesis(x.columnCount() + 1));
	}

	public double iterate() {
		Matrix h = hypothesis.evaluate(x); // Hypothesis
		Matrix theta = hypothesis.getWeights();
		Matrix residual = h.subtract(y);

		Matrix jDifferential = x.transpose().multiplyBy(residual); // d(j)/dTheta

		theta = theta.subtract(jDifferential.multiplyBy(ALPHA)); // Adjusted
																	// theta
		hypothesis = new LogicalHypothesis(theta);

		return getJ(hypothesis); // Cost
									// Function
	}

	private double getJ(Hypothesis h) {
		if (log == null) {
			log = new MatrixElementFunction() {
				@Override
				protected double applyFunction(double element) {
					return Math.log10(element);
				}
			};
		}

		Matrix hOfX = h.evaluate(x);
		Matrix minusY = y.multiplyBy(-1);
		Matrix logH = log.evaluate(hOfX).transpose();

		Matrix part1 = minusY.multiplyBy(logH);

		Matrix yMinusOne = y.subtract(1);
		Matrix oneMinusH = hOfX.subtract(1).multiplyBy(-1);
		Matrix logOneMinusH = log.evaluate(oneMinusH).transpose();

		Matrix part2 = yMinusOne.multiplyBy(logOneMinusH);

		return part1.add(part2).get(0, 0);

	}
}
