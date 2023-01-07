package com.saraya.dto;

public class ErrorMessage {
	
	private String message;

	public ErrorMessage(String message) {
		super();
		this.message = message;
	}

	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorMessage [message=" + message + "]";
	}
	
	
	

}
