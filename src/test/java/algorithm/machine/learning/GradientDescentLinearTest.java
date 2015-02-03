package algorithm.machine.learning;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import algorithm.machine.learning.hypothesis.Hypothesis;
import algorithm.matrix.Matrix;

public class GradientDescentLinearTest {

	private final static double FLOAT_ERROR = 0.1;
	private final static double EXCEPTABLE_ERROR = 0.3;
	private LinearGradientDescent api;

	@Before
	public void setUp() {
		Matrix x = new Matrix(3, 1);
		
		// x1
		x.set(0, 0, 1);
		x.set(1, 0, 2);
		x.set(2, 0, 3);

		Matrix y = new Matrix(3, 1);
		y.set(0, 0, 1);
		y.set(1, 0, 2);
		y.set(2, 0, 3);

		api = new LinearGradientDescent(x, y);
	}

	@Test
	public void shouldStartWithZeroHypothesisWeights() {
		Hypothesis h = api.getHypothesis();
		Matrix theta = h.getWeights();

		assertEquals(0, theta.get(0, 0), FLOAT_ERROR);
		assertEquals(0, theta.get(1, 0), FLOAT_ERROR);
	}

	@Test
	public void shouldFindLinearFit() {
		Hypothesis h = api.getMinimizedHypothesis();
		Matrix theta = h.getWeights();
		
		assertEquals(0, theta.get(0, 0), EXCEPTABLE_ERROR);
		assertEquals(1, theta.get(1, 0), EXCEPTABLE_ERROR);
	}
}
