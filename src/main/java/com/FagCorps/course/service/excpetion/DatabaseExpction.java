package com.FagCorps.course.service.excpetion;

public class DatabaseExpction extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatabaseExpction(Object id ) {
		super("illegal id for delete : "+ id );
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}
