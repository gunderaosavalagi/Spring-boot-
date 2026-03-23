package com.student.exception;

public class InvalidIdException extends RuntimeException {
	
private String msg;

public InvalidIdException (String msg) {
	this.msg=msg;
}

public String toString() {
	return "ID not Found"+msg;
}

}
