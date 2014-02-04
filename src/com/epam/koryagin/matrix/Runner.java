package com.epam.koryagin.matrix;

public class Runner {
		
	public static void main(String[] args) {
		Node<Double> node = new Node<Double>(10.2);
		System.out.println("ID = " + node.getId());
		System.out.println("VALUE = " + node.getValue());
		int dimension = 5;
		Matrix<Node<Double>> matrix = new Matrix<Node<Double>>();
		try {
			matrix = new Matrix<Node<Double>>(dimension, node);
		} catch (MatrixException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(matrix);	
	}
}
