package com.advento.teacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.advento.teacher.dto.ErrorMessageDTO;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler  {

	 @ExceptionHandler({InvalidException.class})
	    public ResponseEntity<ErrorMessageDTO> handleInvalidInputEx(InvalidException iEx) {
	        String errorMessage = iEx.getErrorMessage();
	        String errorCode = iEx.getErrorCode();
	        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(errorMessage, errorCode);
	        ResponseEntity<ErrorMessageDTO> responseEntity = new ResponseEntity<ErrorMessageDTO>(errorMessageDTO, HttpStatus.NOT_FOUND);
	        return responseEntity;
	    }
}
