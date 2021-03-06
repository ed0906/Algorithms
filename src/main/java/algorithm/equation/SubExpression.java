package algorithm.equation;

import org.apache.commons.lang3.builder.EqualsBuilder;

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

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public Expression partialDifferential(String var) {
		return value.partialDifferential(var);
	}
}
