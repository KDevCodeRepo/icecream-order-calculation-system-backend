package com.icecool.ordercalculation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidInputException(String message) {
		super(message);
	}
}
