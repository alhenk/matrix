package com.epam.koryagin.matrix.menu;

import org.apache.log4j.Logger;

import com.epam.koryagin.matrix.Matrices;
import com.epam.koryagin.matrix.exception.MatrixException;
import com.epam.koryagin.matrix.rectangle.Matrix;

public class Menu {
	private static final Logger LOGGER = Logger.getLogger(Matrix.class);
	private State state = State.START;
	private static Matrix<Double> _matrixA;
	private static Matrix<Double> _matrixB;
	
	public State oneStep(int choice){
		switch (state){
		case START:
			displayFirstEntry();
		case ENTER_FIRST_MATRIX:
			createMatrix(choice, _matrixA);
		case ENTER_SECOND_MATRIX:
			createMatrix(choice, _matrixB);
			break;
		case EXIT:	
		default:
			state = State.EXIT;
		}
		return state;
	}
	
	public void displayFirstEntry(){
		StringBuilder sb = new StringBuilder();
		sb.append("Enter a dimension of the first matrix");
		sb.append("0 EXIT");
		System.out.println(sb.toString());
		System.out.print("> ");
	}
	private Matrix<Double> createMatrix(int dimension, Matrix<Double> matrix){
		matrix = new Matrix<Double>();
		try {
			matrix = new Matrix<Double>(Matrices.random(dimension));
		} catch (MatrixException e) {
			LOGGER.error(e);
			e.printStackTrace();
		}
		return matrix;
	}
}
