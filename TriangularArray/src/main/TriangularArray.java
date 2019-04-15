package main;

import java.lang.reflect.Array;

public class TriangularArray<T> {

	private int rows;
	private T[] values;

	@SuppressWarnings("unchecked")
	public TriangularArray(int rows) {
		this.rows = rows;
		this.values = (T[]) Array.newInstance(values.getClass(), rows * (rows - 1) / 2);
	}

	private int mapToIndex(int row, int column) {
		if (row > column) {
			int temp = row;
			row = column;
			column = temp;
		}
		return row * (row - 1) / 2 + column;
	}

	public int getRows() {
		return rows;
	}

	public T getValue(int row, int column) {
		if (row == column) throw new IndexOutOfBoundsException("Indexes are out of bounds! Row canot be equal to column");
		int index = mapToIndex(row, column);
		return values[index];
	}

	public void setValue(T value, int row, int column) {
		int index = mapToIndex(row, column);
		values[index] = value;
	}

	public static void main(String[] args) {
		int size = 5;
		TriangularArray<String> tr = new TriangularArray<>(size);
		tr.setValue("1x2", 1, 2);
		tr.setValue("1x3", 1, 2);
		
	}

}
