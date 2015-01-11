package algorithm.equation;

import algorithm.equation.Expression;

public class SubExpression implements Expression{

	private Expression value;
	
	public SubExpression(Expression value) {
		this.value = value;
	}
	
	@Override
	public Double evaluate() {
		return value.evaluate();
	}
	
	@Override
	public String toString() {
		return "(" + value.evaluate() + ")";
	}
}
