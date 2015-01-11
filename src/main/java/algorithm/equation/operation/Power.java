package algorithm.equation.operation;

import algorithm.equation.Expression;

public class Power implements Expression{

	private Expression lhs;
	private Expression rhs;
	
	public Power(Expression lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	@Override
	public Double evaluate() {
		return Math.pow(lhs.evaluate(), rhs.evaluate());
	}
	
	@Override
	public String toString() {
		return lhs.toString() + "^(" + rhs.toString() + ")";
	}
}
