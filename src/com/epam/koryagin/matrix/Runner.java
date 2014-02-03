package com.epam.koryagin.matrix;

public class Runner {
	public static void main(String[] args) {
		Node<Double> node = new Node<Double>(10.2);
		System.out.println("ID = " + node.getId());
		System.out.println("VALUE = " + node.getValue());
		int dimension = 3;
		Matrix<Node<Double>> matrix = 
				new Matrix<Node<Double>>(dimension, node);
		
		System.out.println(matrix);
	}
}
