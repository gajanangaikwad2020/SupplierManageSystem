package com.supplierman.exception;



public class SupplierNameAlreadyExistException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SupplierNameAlreadyExistException(String msg) 
	{
		super(msg);
	}

	
}
