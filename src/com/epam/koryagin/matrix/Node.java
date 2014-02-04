package com.epam.koryagin.matrix;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Generic class for matrix element
 * @author Alhen
 * @param <T>
 */
public class Node<T> implements Serializable {
	private static final long serialVersionUID = 1L;
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
	/**
	 * Constructor with parameter
	 * @param value
	 */
	public Node(T value){
		this();
		this.value = value;
	}
	/**
	 * Constructor with parameters
	 * @param id
	 * @param value
	 */
	public Node(String id, T value){
		this(value);
		this.id = id;
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
