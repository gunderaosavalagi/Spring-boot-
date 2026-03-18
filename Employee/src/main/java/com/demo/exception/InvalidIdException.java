package com.demo.exception;

public class InvalidIdException  extends RuntimeException{
	
	private String msg;
	
	public InvalidIdException(String msg) {
		this.msg=msg;
	}
	
	public String toString() {
		return "Id not found"+msg;
	}

}
