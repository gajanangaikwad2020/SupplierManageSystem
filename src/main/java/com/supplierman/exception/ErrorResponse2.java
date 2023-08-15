package com.supplierman.exception;

public class ErrorResponse2 
{
	private String timeStamp;
	private String message;
	
	public ErrorResponse2() 
	{
		super();
		
	}

	public ErrorResponse2(String timeStamp, String message) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}