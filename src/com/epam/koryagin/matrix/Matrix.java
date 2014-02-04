package com.epam.koryagin.matrix;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


/**
 * Generic class Matrix 
 * @author Alhen
 *
 * @param <T>
 */
public class Matrix<T> {
	private static final Logger LOGGER = Logger.getLogger(Matrix.class);
	private int row;
	private int column;
	private List<List<T>> matrix =
			new  ArrayList<List<T>>();
	
	public Matrix(){
		super();
	}
	
	/**
	 * Constructor of square matrix
	 * @param row
	 * @param object
	 * @throws MatrixException 
	 */
	public Matrix(int row, T object) throws MatrixException{
		if (row < 0 ){
			LOGGER.error("Negative row number");
			throw new MatrixException("Negative row number");
		}
		this.row = row;
		this.column = row;
		this.setMatrix(new  ArrayList<List<T>>());
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
	 * @throws MatrixException 
	 */
	public Matrix (int row, int column, T object) throws MatrixException{
		if (row < 0 || column < 0){
			LOGGER.error("Negative row or column number");
			throw new MatrixException("Negative row or column number");}
		this.row = row;
		this.column = column;
		this.setMatrix(new  ArrayList<List<T>>());
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
	/**
	 * set row with range checking
	 * @param row
	 * @throws MatrixException
	 */
	public void setRow(int row) throws MatrixException {
		if (row < 0 || row > this.matrix.size()  ){
			LOGGER.error("Negative row number");
			throw new MatrixException("Negative row number");}
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	/**
	 * set column with range checking
	 * @param column
	 * @throws MatrixException
	 */
	public void setColumn(int column) throws MatrixException {
		if (column < 0 ){
			LOGGER.error("Negative column number");
			throw new MatrixException("Negative column number");}
		this.column = column;
	}

	/**
	 * Generate a new instance 
	 * of the matrix collection field
	 * @return copyMatrix 
	 */
	public List<List<T>> yieldMatrix() {
		List<List<T>> newMatrix = new  ArrayList<List<T>>();
		for(List<T> list : this.matrix){
			newMatrix.add(list);
		}
		return newMatrix;
	}

	/**
	 * Copy the collection in matrix field 
	 * @return void
	 */
	public void copyMatrix(List<List<T>> matrix) {
		List<List<T>> newMatrix = new  ArrayList<List<T>>();
		for(List<T> list : matrix){
			ArrayList<T> tuple = new ArrayList<T>(list); 
			newMatrix.add(tuple);
		}
		this.matrix = newMatrix;

	}
	/**
	 * Unsafe getter
	 * @return
	 */
	public List<List<T>> getMatrix() {
		return matrix;
	}
	/**
	 * Unsafe setter
	 * @param matrix
	 */
	public void setMatrix(List<List<T>> matrix) {
		this.matrix = matrix;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(List<T> tuple : matrix){
			for(T element : tuple){
				sb.append(element);
				sb.append("\t");
			}
			sb.append("\n");
		}
//		for(int i = 0; i<this.row; i++){
//			for(int j = 0; j<this.column; j++){
//				sb.append(this.matrix.get(i).get(j));
//				sb.append("\t");
//			}
//			sb.append("\n");
//		}
		return sb.toString();
	}

	

}
