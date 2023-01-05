package com.advento.teacher.exception;

public class InvalidException extends RuntimeException  {

	
	 private static final long serialVersionUID = 1L;

	    private String errorMessage;
	    
	    private String errorCode;

	    public InvalidException(String errorMessage, String errorCode) {
	        super();
	        this.errorMessage = errorMessage;
	        this.errorCode = errorCode;
	    }

	    public String getErrorMessage() {
	        return errorMessage;
	    }

	    public void setErrorMessage(String errorMessage) {
	        this.errorMessage = errorMessage;
	    }

	    public String getErrorCode() {
	        return errorCode;
	    }

	    public void setErrorCode(String errorCode) {
	        this.errorCode = errorCode;
	    }
}
