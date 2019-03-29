package com.trax.ratemanager.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

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
	private String path;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;

	private List<String> details;

	private ErrorResponse()
	{
		timestamp = LocalDateTime.now();
	}

	public ErrorResponse(String message, List<String> details, Throwable ex, HttpStatus status, WebRequest request)
	{
		this();
		this.message = message;
		this.details = details;
		this.debugMessage = ex.getLocalizedMessage();
		this.status = status;
		this.path = request.getDescription(false);
	}

}
