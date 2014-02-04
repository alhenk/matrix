package com.epam.koryagin.matrix;

import java.util.ArrayList;
import java.util.List;

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
			e.printStackTrace();
		}
		
		System.out.println(matrix);	
		
		List<Double> list = new ArrayList<Double>();
		list.add(2.3);
		list.add(2.3);
		list.add(2.3);
		list.add(2.3);
		list.add(2.3);
		
		List<List<Double>> biglist = new ArrayList<List<Double>>();
		biglist.add(list);
		biglist.add(list);
		biglist.add(list);

		
		System.out.println("List Size = " + list.size());
		System.out.println("Big List Size = " + biglist.size());
		
		Matrix<Double> shmatrix = new Matrix<Double>();

		
		shmatrix.copyMatrix(biglist);
		
		System.out.println(shmatrix);	
		
	}
}
