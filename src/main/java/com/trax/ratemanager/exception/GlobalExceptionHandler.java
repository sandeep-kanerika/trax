package com.trax.ratemanager.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request)
	{
		ex.printStackTrace();
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Server error", details, ex, HttpStatus.INTERNAL_SERVER_ERROR, request);
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request)
	{
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Record Not Found", details, ex, HttpStatus.INTERNAL_SERVER_ERROR, request);
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
	{
		List<String> details = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors())
		{
			details.add(error.getDefaultMessage());
		}
		ErrorResponse error = new ErrorResponse("Method Argument Validation Failed", details, ex, HttpStatus.INTERNAL_SERVER_ERROR, request);
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({TransactionSystemException.class})
	public ResponseEntity<Object> handleConstraintViolation(Exception ex, WebRequest request)
	{
		Throwable cause = ((TransactionSystemException) ex).getRootCause();
		if (cause instanceof ConstraintViolationException)
		{
			ErrorResponse error = new ErrorResponse("Validation Failed", null, cause, HttpStatus.INTERNAL_SERVER_ERROR, request);
			return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
		}
		return null;
	}

}