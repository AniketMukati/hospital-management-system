package com.springSecurity.customException;

public class ResourceNotFoundException extends RuntimeException {
	
	
	private String fieldName;
	
	private String field;
	
	private long id;

	public ResourceNotFoundException(String fieldName, String field, long id) {
		super();
		this.fieldName = fieldName;
		this.field = field;
		this.id = id;
	}

	public ResourceNotFoundException() {
		super();
	}
	

	
	
	
	
}
