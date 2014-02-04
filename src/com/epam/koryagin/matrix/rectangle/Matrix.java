package com.epam.koryagin.matrix.rectangle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.epam.koryagin.matrix.exception.MatrixException;

/**
 * Generic class Matrix 
 * @author Alhen
 * @param <T>
 */
public class Matrix<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(Matrix.class);
	private int row;
	private int column;
	private List<List<T>> matrix =
			new  ArrayList<List<T>>();
	
	/**
	 * Create identity matrix collection
	 * @param size
	 * @return
	 * @throws MatrixException 
	 */
	public static List<List<Double>> identity(int size) throws MatrixException{
		if ( size < 0 ){
			LOGGER.error("Negative matrix size");
			throw new MatrixException("Negative matrix size");
		}
		List<List<Double>> identity = new  ArrayList<List<Double>>();
		for(int i=0; i < size; i++){
				identity.add(new ArrayList<Double>());
				for(int j = 0; j < size; j++){
					if(i==j){
						identity.get(i).add(1.0);
					} else {
						identity.get(i).add(0.0);
					}
				}
		}
		return identity;
	}
	
	public static List<List<Double>> random(int size) throws MatrixException{
		long start = System.nanoTime();
		if ( size < 0 ){
			LOGGER.error("Negative matrix size");
			throw new MatrixException("Negative matrix size");
		}
		List<List<Double>> random = new  ArrayList<List<Double>>();
		for(int i=0; i < size; i++){
				random.add(new ArrayList<Double>());
				for(int j = 0; j < size; j++){
					int value = -size + (int)(Math.random() * ((size - (-size)) + 1));
					random.get(i).add(new Double(value));
				}
		}
		LOGGER.info("Random matrix creatin time "+ (System.nanoTime()-start)+ "nano sec" );
		return random;
	}
	
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
		if ( row < 0 ){
			LOGGER.error("Negative row number");
			throw new MatrixException("Negative row number");
		}
		this.row = row;
		this.column = row;
		this.setMatrix(new  ArrayList<List<T>>());
		for(int i=0; i < row; i++){
				this.matrix.add(new ArrayList<T>());
				for(int j = 0; j < row; j++){
					this.matrix.get(i).add(object);
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
		if (row < 0 || column < 0 ){
			LOGGER.error("Negative row or column number");
			throw new MatrixException("Negative row or column number");}
		this.row = row;
		this.column = column;
		this.matrix = new  ArrayList<List<T>>();
		for(int i=0; i < row; i++){
				this.matrix.add(new ArrayList<T>());
				for(int j = 0; j < column; j++){
					this.matrix.get(i).set(j, object);
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
			LOGGER.error("row number is out of range");
			throw new MatrixException("row number is out of range");}
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	/**
	 * Set column with range checking
	 * @param column
	 * @throws MatrixException
	 */
	public void setColumn(int column) throws MatrixException {
		if (column < 0 || column > this.column() ){
			LOGGER.error("column number is out of range");
			throw new MatrixException("column number is out of range");}
		this.column = column;
	}

	/**
	 * Generate a new instance 
	 * of the 2D List<T>
	 * @return newMatrix 
	 */
	public List<List<T>> yieldMatrix() {
		List<List<T>> newMatrix = new  ArrayList<List<T>>();
		for(List<T> list : this.matrix){
			newMatrix.add(list);
		}
		return newMatrix;
	}

	/**
	 * copying constructor -
	 * copy the collection in matrix field
	 * initialized row and column fields
	 * the column value is the maximum length of tuples
	 * @param - 2D List<T> 
	 * @return void
	 */
	public Matrix(List<List<T>> matrix) {
		List<List<T>> newMatrix = new  ArrayList<List<T>>();
		for(List<T> list : matrix){
			ArrayList<T> tuple = new ArrayList<T>(list); 
			newMatrix.add(tuple);
		}
		this.matrix = newMatrix;
		this.row = newMatrix.size();
		this.column = column();
	}
	/**
	 * Unsafe getter
	 * direct access through the reference
	 * @return
	 */
	public List<List<T>> getMatrix() {
		return matrix;
	}
	/**
	 * Unsafe setter
	 * direct access through the reference
	 * @param matrix
	 */
	public void setMatrix(List<List<T>> matrix) {
		this.matrix = matrix;
	}
	/**
	 * return maximum length of the tuples in the matrix
	 * @return
	 */
	private int column(){
		int maxLength = 0;
		for(List<T> list : matrix){
			if(list.size() > maxLength){
				maxLength = list.size(); 
			}
		}
		return 0;
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
		return sb.toString();
	}
}
