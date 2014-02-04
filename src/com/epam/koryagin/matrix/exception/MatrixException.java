package com.epam.koryagin.matrix.exception;

public class MatrixException extends Exception{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs a new exception with <code>null</code> as its detail message.
	 */
	public MatrixException() {
		super();
	}

	/**
	 * Constructs a new exception with the specified detail message.
	 * @param message the detail message.
	 */
	public MatrixException(String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified cause and a detail message
	 * of <tt>(cause==null ? null : cause.toString())</tt> (which typically
	 * contains the class and detail message of <tt>cause</tt>).
	 * 
	 * @param cause the cause.
	 */
	public MatrixException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * @param message the message.
	 * @param cause the cause.
	 */
	public MatrixException(String message, Throwable cause) {
		super(message, cause);
	}

	
	
	
	
	
}
