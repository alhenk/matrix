package com.epam.koryagin.matrix;

import java.util.ArrayList;
/**
 * Generic class Matrix 
 * @author Alhen
 *
 * @param <T>
 */
public class Matrix<T> {
	private int row;
	private int column;
	private ArrayList<ArrayList<T>> matrix =
			new  ArrayList<ArrayList<T>>();
	
	public Matrix(){
		super();
	}
	
	/**
	 * Constructor of square matrix
	 * @param row
	 * @param object
	 */
	public Matrix(int row, T object){
		this.row = row;
		this.column = row;
		this.setMatrix(new  ArrayList<ArrayList<T>>());
		for(int i=0; i < row; i++){
				this.getMatrix().add(new ArrayList<T>());
				for(int j = 0; j < row; j++){
					this.getMatrix().get(i).add(object);
				}
		}
	}
	
	/**
	 * Constructor of rectangle matrix
	 * @param row
	 * @param column
	 * @param object
	 */
	public Matrix(int row, int column, T object){
		this.row = row;
		this.column = column;
		this.setMatrix(new  ArrayList<ArrayList<T>>());
		for(int i=0; i < row; i++){
				this.getMatrix().add(new ArrayList<T>());
				for(int j = 0; j < column; j++){
					this.getMatrix().get(i).set(j, object);
				}
		}
	}
		
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}

	public ArrayList<ArrayList<T>> getMatrix() {
		return matrix;
	}

	public void setMatrix(ArrayList<ArrayList<T>> matrix) {
		this.matrix = matrix;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<this.row; i++){
			for(int j = 0; j<this.column; j++){
				sb.append(this.matrix.get(i).get(j));
				sb.append("\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	

}
