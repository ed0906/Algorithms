package algorithm.matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MatrixElementFunctionTest {

	private final static double FLOAT_ERROR = 0.1;
	private Matrix m;
	
	@Before
	public void setUp() {
		m = new Matrix(2,2);
		
		m.set(0, 0, 1);
		m.set(0, 1, 2);
		m.set(1, 0, 3);
		m.set(1, 1, 4);
	}
	
	@Test
	public void shouldApplyFunction() {
		//Given
		MatrixElementFunction inverter = new MatrixElementFunction(){
			@Override
			public double applyFunction(double element) {
				if(element != 0) {
					return 1 / element;
				}return 0;
			}
		};
		
		//When
		Matrix output = inverter.evaluate(m);
		
		//Then
		assertEquals(1, output.get(0, 0), FLOAT_ERROR);
		assertEquals(0.5, output.get(0, 1), FLOAT_ERROR);
		assertEquals(0.33, output.get(1, 0), FLOAT_ERROR);
		assertEquals(0.25, output.get(1, 1), FLOAT_ERROR);
	}
}
