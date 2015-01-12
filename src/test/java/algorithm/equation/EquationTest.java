package algorithm.equation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import algorithm.equation.constant.Constant;
import algorithm.equation.operation.Add;
import algorithm.equation.operation.Ln;
import algorithm.equation.operation.Multiply;
import algorithm.equation.operation.Power;
import algorithm.equation.operation.Sine;
import algorithm.equation.operation.Subtract;
import algorithm.equation.variable.Variable;

public class EquationTest {

	@Test
	public void shouldAddTwoConstants() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		
		Expression sum = new Add(c1,c2);
		Double result = sum.evaluate();
		
		assertEquals(3, result.intValue());
		assertEquals("1 + 2", sum.toString());
	}
	
	@Test
	public void shouldSubtractTwoConstants() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		
		Expression sum = new Subtract(c1,c2);
		Double result = sum.evaluate();
		
		assertEquals(-1, result.intValue());
		assertEquals("1 - 2", sum.toString());
	}
	
	@Test
	public void shouldMultiplyTwoConstants() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		
		Expression sum = new Multiply(c1,c2);
		Double result = sum.evaluate();
		
		assertEquals(2, result.intValue());
		assertEquals("1 * 2", sum.toString());
	}
	
	@Test
	public void shouldMultiplyMoreThanTwoConstants() {
		Constant c1 = new Constant(1);
		Constant c2 = new Constant(2);
		Constant c3 = new Constant(3);
		
		Expression sum = new Multiply(c1,c2,c3);
		Double result = sum.evaluate();
		
		assertEquals(6, result.intValue());
		assertEquals("1 * 2 * 3", sum.toString());
	}
	
	@Test
	public void shouldLogAConstant() {
		Constant c1 = new Constant(1);
		
		Expression sum = new Ln(c1);
		Double result = sum.evaluate();
		
		assertEquals(0, result.intValue());
		assertEquals("Ln(1)", sum.toString());
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWhenEvaluatingEmptyVariable() {
		Variable var = new Variable("x");
		
		var.evaluate();
		fail("No exception thrown");
	}
	
	@Test
	public void shouldEvaluateVariable() {
		Variable var = new Variable("x");
		var.setValue(new Constant(2));
		
		assertEquals(2, var.evaluate().intValue());
	}
	
	@Test
	public void shouldDifferentiateVariable() {
		Variable var = new Variable("x");
		
		Expression dVar = var.partialDifferential("x");
		
		assertEquals(1, dVar.evaluate().intValue());
	}
	
	@Test
	public void shouldDifferentiateAVariableSquared() {
		Variable var = new Variable("x", new Constant(1));
		Power varSquared = new Power(var, new Constant(2));
		
		Expression dVar = varSquared.partialDifferential("x");
		
		assertEquals(2, dVar.evaluate().intValue());
	}
	
	@Test
	public void shouldDifferentiateNaturalLog() {
		Variable var = new Variable("x", new Constant(0.5));
		Expression logE = new Ln(var);
		
		Expression dLogE = logE.partialDifferential("x");
		
		assertEquals(2, dLogE.evaluate().intValue());
	}
	
	@Test
	public void sineShouldDifferentiateToCos() {
		Sine sine = new Sine(new Variable("x", new Constant(0)));
		
		Expression diff = sine.partialDifferential("x");
		
		assertEquals(1, diff.evaluate().intValue());
	}
}
