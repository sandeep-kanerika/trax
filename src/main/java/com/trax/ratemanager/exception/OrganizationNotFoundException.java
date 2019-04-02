package com.trax.ratemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrganizationNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;

	public OrganizationNotFoundException(String message)
	{
		super(message);
	}
}
