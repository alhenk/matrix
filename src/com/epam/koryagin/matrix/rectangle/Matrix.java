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
	private int height;
	private int width;
	private List<List<T>> array;
	
	/**
	 * Default constructor
	 * to be on the safe side
	 */
	public Matrix(){
		super();
	}
	
	/**
	 * Constructor of square matrix
	 * @param height
	 * @param object
	 * @throws MatrixException 
	 */
	public Matrix(int height, T object) throws MatrixException{
		if ( height < 0 ){
			LOGGER.error("Negative row number");
			throw new MatrixException("Negative row number");
		}
		this.height = height;
		this.width = height;
		this.array = new  ArrayList<List<T>>();
		for(int i=0; i < height; i++){
				this.array.add(new ArrayList<T>());
				for(int j = 0; j < height; j++){
					this.array.get(i).add(object);
				}
		}
	}
	
	/**
	 * Constructor of rectangle matrix
	 * @param hight
	 * @param width
	 * @param object
	 * @throws MatrixException 
	 */
	public Matrix (int hight, int width, T object) throws MatrixException{
		if (hight < 0 || width < 0 ){
			LOGGER.error("Negative row or column number");
			throw new MatrixException("Negative row or column number");}
		this.height = hight;
		this.width = width;
		this.array = new  ArrayList<List<T>>();
		for(int i=0; i < hight; i++){
				this.array.add(new ArrayList<T>());
				for(int j = 0; j < width; j++){
					this.array.get(i).add(object);
				}
		}
	}
	/**
	 * Get dimension - rows	
	 * @return row number
	 */
	public int getHight() {
		return height;
	}
	/**
	 * set row with range checking
	 * @param hight
	 * @throws MatrixException
	 */
	public void setHight(int hight) throws MatrixException {
		if (hight < 0 || hight > this.array.size()  ){
			LOGGER.error("row number is out of range");
			throw new MatrixException("row number is out of range");}
		this.height = hight;
	}
	/**
	 * Get dimension - columns
	 * @return column number
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Set column with range checking
	 * @param width
	 * @throws MatrixException
	 */
	public void setWidth(int width) throws MatrixException {
		if (width < 0 || width > this.getMaxWidth() ){
			LOGGER.error("column number is out of range");
			throw new MatrixException("column number is out of range");}
		this.width = width;
	}

	/**
	 * Generate a new instance 
	 * of the 2D List<T>
	 * @return newMatrix 
	 */
	public List<List<T>> cloneArray() {
		List<List<T>> newArray = new  ArrayList<List<T>>();
		for(List<T> list : this.array){
			newArray.add(list);
		}
		return newArray;
	}

	/**
	 * copying constructor -
	 * copy the collection in matrix field
	 * initialized row and column fields
	 * the column value is the maximum length of tuples
	 * @param - 2D List<T> 
	 * @return void
	 */
	public Matrix(List<List<T>> array) {
		List<List<T>> newMatrix = new  ArrayList<List<T>>();
		for(List<T> list : array){
			ArrayList<T> tuple = new ArrayList<T>(list); 
			newMatrix.add(tuple);
		}
		this.array = newMatrix;
		this.height = newMatrix.size();
		this.width = getMaxWidth();
	}
	/**
	 * Unsafe getter
	 * direct access through the reference
	 * @return
	 */
	public List<List<T>> getMatrix() {
		return array;
	}
	/**
	 * Unsafe setter
	 * direct access through the reference
	 * @param matrix
	 */
	public void setMatrix(List<List<T>> matrix) {
		this.array = matrix;
	}
	/**
	 * return maximum length of the tuples in the matrix
	 * @return
	 */
	private int getMaxWidth(){
		int maxLength = 0;
		for(List<T> list : array){
			//System.out.println("list size"+list.size());
			if(list.size() > maxLength){
				maxLength = list.size(); 
			}
		}
		return maxLength;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(List<T> tuple : array){
			for(T element : tuple){
				sb.append(element);
				sb.append("\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
