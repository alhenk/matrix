package com.epam.koryagin.matrix;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Generic class for matrix element
 * @author Alhen
 *
 * @param <T>
 */
public class Node<T> {
	private String id;
	private T value;
	
	/**
	 * Default constructor
	 */
	public Node(){
		super();
		SecureRandom random = new SecureRandom();
		this.id = new BigInteger(130, random).toString(32);
	}
	
	public Node(T value){
		this();
		this.value = value;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.getValue());
		return sb.toString();
	}
}
