package algorithm.equation.operation;

import algorithm.equation.Expression;

public class Divide implements Expression{

	private Expression lhs;
	private Expression rhs;
	
	public Divide(Expression lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	@Override
	public Double evaluate() {
		return lhs.evaluate() / rhs.evaluate();
	}
	
	@Override
	public String toString() {
		return lhs.toString() + " / " + rhs.toString();
	}
}
