package com.trax.ratemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = 1724688309695540471L;

	public ResourceNotFoundException(String message)
	{
		super(message);
	}

	public ResourceNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
