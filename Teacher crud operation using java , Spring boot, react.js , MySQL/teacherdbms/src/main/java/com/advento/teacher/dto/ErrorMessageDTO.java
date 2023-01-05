package com.advento.teacher.dto;

public class ErrorMessageDTO {

	
		private String errMessage;
		    
		    private String errCode;

		    public ErrorMessageDTO(String errMessage, String errCode) {
		        super();
		        this.errMessage = errMessage;
		        this.errCode = errCode;
		    }

		    public String getErrMessage() {
		        return errMessage;
		    }

		    public void setErrMessage(String errMessage) {
		        this.errMessage = errMessage;
		    }

		    public String getErrCode() {
		        return errCode;
		    }

		    public void setErrCode(String errCode) {
		        this.errCode = errCode;
		    }
		
}
