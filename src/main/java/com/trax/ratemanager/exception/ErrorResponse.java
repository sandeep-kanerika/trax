package com.trax.ratemanager.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse
{
	private HttpStatus status;
	private String message;
	private String debugMessage;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	private List<String> errors;


	private ErrorResponse()
	{
		timestamp = LocalDateTime.now();
	}

	public ErrorResponse(HttpStatus status)
	{
		this();
		this.status = status;
	}
	public ErrorResponse(HttpStatus status, List<String> errors)
	{
		this();
		this.status = status;
		this.errors = errors;
	}

	public ErrorResponse(HttpStatus status, Throwable ex)
	{
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	public ErrorResponse(HttpStatus status, String message, Throwable ex)
	{
		this(status, ex);
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

	public ErrorResponse(String message, List<String> details, Throwable ex, HttpStatus status)
	{
		this();
		this.message = message;
		this.errors = details;
		this.debugMessage = ex.getMessage();
		this.status = status;
	}

}
