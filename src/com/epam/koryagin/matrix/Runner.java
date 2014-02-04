package com.epam.koryagin.matrix;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import com.epam.koryagin.matrix.exception.MatrixException;
import com.epam.koryagin.matrix.node.Node;
import com.epam.koryagin.matrix.rectangle.Matrix;

public class Runner {
	private static final Logger LOGGER = Logger.getLogger(Runner.class);
		
	public static void main(String[] args) {
		Node<Double> node = new Node<Double>(10.2);
		System.out.println("ID = " + node.getId());
		System.out.println("VALUE = " + node.getValue());
		
		int dimension = 5;
		Matrix<Node<Double>> matrix = new Matrix<Node<Double>>();
		try {
			matrix = new Matrix<Node<Double>>(dimension, node);
			StringBuilder sb = new StringBuilder()
					.append("The Matrix ")
					.append(dimension).append("x").append(dimension)
					.append(" of ").append(node.getClass())
					.append(" created");
			LOGGER.info(sb.toString());
			System.out.println(sb.toString());
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

		
		try {
			shmatrix = new Matrix<Double>(Matrix.random(4));
		} catch (MatrixException e){
			System.err.println(e);
		}
		
		System.out.println(shmatrix);
		
		
		
	}
}
