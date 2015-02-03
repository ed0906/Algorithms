package algorithm.matrix;

public abstract class MatrixElementFunction {

	private Matrix output;
	
	private void evaluateFunction(Matrix input) {
		output = new Matrix(input.rowCount(), input.columnCount());
		
		for(int r = 0; r < output.rowCount(); r++) {
			for(int c = 0; c < output.columnCount(); c++) {
				output.set(r, c, applyFunction(input.get(r, c)));
			}
		}
	}
	
	public Matrix evaluate(Matrix m) {
		if(output == null) {
			evaluateFunction(m);
		}
		return output;
	}
	
	protected abstract double applyFunction(double element);
}
