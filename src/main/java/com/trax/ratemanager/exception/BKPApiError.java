package com.trax.ratemanager.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BKPApiError
{

	private HttpStatus status;
	private String message;
	private List<String> errors;

	public BKPApiError(HttpStatus status, String message, List<String> errors)
	{
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public BKPApiError(HttpStatus status, String message, String error)
	{
		super();
		this.status = status;
		this.message = message;
		errors = Arrays.asList(error);
	}
}