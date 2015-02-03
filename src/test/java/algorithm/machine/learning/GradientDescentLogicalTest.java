package algorithm.machine.learning;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import algorithm.machine.learning.hypothesis.Hypothesis;
import algorithm.matrix.Matrix;

public class GradientDescentLogicalTest {

	private final static double FLOAT_ERROR = 0.1;
	private final static double EXCEPTABLE_ERROR = 0.3;
	private LogicalGradientDescent api;

	@Before
	public void setUp() {
		Matrix x = new Matrix(4, 1);

		// x1
		x.set(0, 0, -2);
		x.set(1, 0, -1);
		x.set(2, 0, 1);
		x.set(3, 0, 2);

		Matrix y = new Matrix(4, 1);
		y.set(0, 0, 0);
		y.set(1, 0, 0);
		y.set(2, 0, 1);
		y.set(3, 0, 1);

		api = new LogicalGradientDescent(x, y);
	}

	@Test
	public void shouldStartWithZeroHypothesisWeights() {
		Hypothesis h = api.getHypothesis();
		Matrix theta = h.getWeights();

		assertEquals(2, theta.rowCount());
		assertEquals(1, theta.columnCount());
		assertEquals(0, theta.get(0, 0), FLOAT_ERROR);
		assertEquals(0, theta.get(1, 0), FLOAT_ERROR);
	}

	@Test
	public void shouldFindLogicalFit() {
		// Given
		Hypothesis h = api.getMinimizedHypothesis();
		Matrix xTrial = new Matrix(1, 2);
		xTrial.set(0, 0, 1); // x = [1, ?] (prepend x0=1)
		
		//When
		Matrix theta = h.getWeights();
		
		//Then
		assertEquals(0, theta.get(0, 0), EXCEPTABLE_ERROR);
		
		// When
		xTrial.set(0, 1, -100);// x = [1, -10]
		Matrix yActual = h.evaluate(xTrial);

		// Then
		assertEquals(0, yActual.get(0, 0), EXCEPTABLE_ERROR);

		// When
		xTrial.set(0, 1, 100);// x = [1, 10]
		yActual = h.evaluate(xTrial);

		// Then
		assertEquals(1, yActual.get(0, 0), EXCEPTABLE_ERROR);

		// When
		xTrial.set(0, 1, 0);// x = [1, 0]
		yActual = h.evaluate(xTrial);

		// Then
		assertEquals(0.5, yActual.get(0, 0), EXCEPTABLE_ERROR);
	}
}
