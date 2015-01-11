package algorithm.equation.operation;

import algorithm.equation.Expression;

public class Log10 implements Expression{
	
	private Expression value;
	
	public Log10(Expression value) {
		this.value = value;
	}

	@Override
	public Double evaluate() {
		return Math.log10(value.evaluate());
	}

	@Override
	public String toString() {
		return "Log10(" + value.toString() + ")";
	}
}
