package algorithm.equation.operation;

import org.apache.commons.lang3.builder.EqualsBuilder;

import algorithm.equation.Expression;
import algorithm.equation.constant.Constant;

public class Cosine implements Expression {

	private Expression argument;

	public Cosine(Expression value) {
		this.argument = value;
	}

	@Override
	public Double evaluate() {
		return Math.cos(argument.evaluate());
	}

	@Override
	public String toString() {
		return "Cos(" + argument.toString() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public Expression partialDifferential(String var) {
		return new Multiply(new Sine(argument), new Constant(-1));
	}
}
