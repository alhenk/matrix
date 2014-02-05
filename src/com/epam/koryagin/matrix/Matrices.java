package com.epam.koryagin.matrix;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.epam.koryagin.matrix.exception.MatrixException;
import com.epam.koryagin.matrix.rectangle.Matrix;

public class Matrices {
	private static final Logger LOGGER = Logger.getLogger(Matrices.class);
	
	/**
	 * Create identity matrix collection
	 * @param size
	 * @return
	 * @throws MatrixException 
	 */
	public static List<List<Double>> identity(int size){
		if ( size < 0 ){
			LOGGER.error("Negative matrix size");
			try {
				throw new MatrixException("Negative matrix size");
			} catch (MatrixException e) {
				e.printStackTrace();
			}
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
	
	/**
	 * Create zero matrix collection
	 * @param size
	 * @return
	 * @throws MatrixException 
	 */
	public static List<List<Double>> zerro(int size) throws MatrixException{
		if ( size < 0 ){
			LOGGER.error("Negative matrix size");
			throw new MatrixException("Negative matrix size");
		}
		List<List<Double>> zerro = new  ArrayList<List<Double>>();
		for(int i=0; i < size; i++){
			zerro.add(new ArrayList<Double>());
				for(int j = 0; j < size; j++){
					zerro.get(i).add(0.0);
				}
		}
		return zerro;
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
		LOGGER.info("Random matrix creation time "+ (System.nanoTime()-start)+ " nano sec" );
		return random;
	}
	/**
	 * Multiply two matrices A X B
	 * @param matrixA
	 * @param matrixB
	 * @return matrixC the product result
	 * @throws Exception
	 */
	public static Matrix<Double> multiply(Matrix<Double> matrixA, Matrix<Double> matrixB ) throws Exception{
		int hightB = matrixB.getHight();
		int widthA = matrixA.getWidth(); 
		int hightC = matrixA.getHight();
		int widthC = matrixB.getWidth();
		if (widthA != hightB) 
			throw new Exception();
		Matrix<Double> matrixC = new Matrix<Double>();
		try {
			matrixC = new Matrix<Double>(hightC, widthC, new Double(0.0));
		} catch (MatrixException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < widthA; i++) {
		for (int j = 0; j < hightB; j++) {
			double value = 0.0;
			for (int k = 0; k < widthC; k++) { 
				value += matrixA.getMatrix().get(i).get(k) * matrixB.getMatrix().get(k).get(j) ;
			}
			matrixC.getMatrix().get(i).set(j, new Double(value));
		}
		}
		return matrixC;
	}
	/**
	 * Util class with only static methods
	 */
	private Matrices(){
		super();
	}

}
