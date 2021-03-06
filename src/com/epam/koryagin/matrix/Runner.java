package com.epam.koryagin.matrix;

import java.util.Scanner;
import org.apache.log4j.Logger;

import com.epam.koryagin.matrix.exception.MatrixException;
import com.epam.koryagin.matrix.rectangle.Matrix;

public class Runner {
	private static final Logger LOGGER = Logger.getLogger(Runner.class);
		
	public static void main(String[] args) {
		
		Matrix<Integer> shmatrixA = new Matrix<Integer>();
		Matrix<Integer> shmatrixB = new Matrix<Integer>();
		Matrix<Integer> shmatrixC = new Matrix<Integer>();
		try {
			shmatrixA = new Matrix<Integer>(Matrices.randomInteger(3));
			System.out.println("Matrix A is created");
			System.out.println(shmatrixA);
		} catch (MatrixException e1) {
			e1.printStackTrace();
		}
		try {
			shmatrixB = new Matrix<Integer>(Matrices.randomInteger(3));
			System.out.println("Matrix B is created");
			System.out.println(shmatrixB);
		} catch (MatrixException e1) {
			e1.printStackTrace();
		}
		
		try {
			shmatrixC = Matrices.multiplyInteger(shmatrixA, shmatrixB);
			System.out.println("C = A x B");
			System.out.println(shmatrixC);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		Matrix<Double> matrixA= new Matrix<Double>();
		Matrix<Double> matrixB= new Matrix<Double>();
		Matrix<Double> matrixC= new Matrix<Double>();
		
		Scanner userInput = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter dimension of the matrix A");
		int dimension = 0;
		boolean state = true;
		while(state){
			if (userInput.hasNext()) {
				if (!userInput.hasNextInt()){
					userInput.next();
					System.out.println("Please enter a natural digit.");
					continue;
				}
				dimension = userInput.nextInt();
				try {
					matrixA= new Matrix<Double>(Matrices.randomDouble(dimension));
					System.out.println("Matrix A is created");
					System.out.println(matrixA);
					LOGGER.info("Matrix A is created"); 
				} catch (MatrixException e) {
					e.printStackTrace();
				}
				state = false;
			}
		}
		
		System.out.println();
		System.out.println("Enter dimension of the matrix B");
		state = true;
		while(state){
			if (userInput.hasNext()) {
				if (!userInput.hasNextInt()){
					userInput.next();
					System.out.println("Please enter a natural digit.");
					continue;
				}
				dimension = userInput.nextInt();
				try {
					matrixB= new Matrix<Double>(Matrices.randomDouble(dimension));
					System.out.println("Matrix B is created");
					System.out.println(matrixB);
					LOGGER.info("Matrix B is created"); 
				} catch (MatrixException e) {
					e.printStackTrace();
				}
				state = false;
			}
		}
		
		try {
			matrixC = Matrices.multiplyDouble(matrixA, matrixB);
			System.out.println("C = A x B");
			System.out.println(matrixC);
			LOGGER.info("Matrix C is created"); 
		} catch (Exception e) {
			e.printStackTrace();
		}

		userInput.close();
	}
}
