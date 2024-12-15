package com.FagCorps.course.entites.Enums;

import java.util.Iterator;

public enum OrderStatus {

	
	WATTING_PEYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code; 
	
	
	private OrderStatus(int code) {
		
		this.code = code;
	}


	public int getCode() {
		return code;
	}
	
	
	
	public static OrderStatus ValueOf(int code) {
		
		
		for (OrderStatus value : OrderStatus.values()) {
			
			if(value.getCode() == code) {
				return value;
				
				
				
			}	
				
			
		
		
		
		
		
		
	}
	
	
	
		throw new IllegalArgumentException("Estado não identificado");

	
}
}