package com.FagCorps.course.service.excpetion;

public class ResourceNotFoundExpetion extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExpetion(Object id) {
		// TODO Auto-generated constructor stub
		
		super("Resource Not Found. id  " + id);
	}
	
	
	
}
