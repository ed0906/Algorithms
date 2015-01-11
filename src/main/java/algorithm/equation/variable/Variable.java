package algorithm.equation.variable;

import org.apache.commons.lang3.builder.EqualsBuilder;

import algorithm.equation.Expression;
import algorithm.equation.constant.Constant;

public class Variable implements Expression {

	private String name;
	private Expression value;

	public Variable(String name){
		this.name = name;
	}
	
	public Variable(String name, Expression value) {
		this.name = name;
		this.value = value;
	}

	public void setValue(Expression value) {
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public Double evaluate() {
		if (value == null) {
			throw new RuntimeException("Cannot evaluate an un-set variable");
		}
		return value.evaluate();
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public Expression partialDifferential(String var) {
		if(name.equals(var)){
			return new Constant(1);
		}return new Constant(0);		
	}
}
