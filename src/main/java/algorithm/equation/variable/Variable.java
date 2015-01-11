package algorithm.equation.variable;

import algorithm.equation.Expression;

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
}
