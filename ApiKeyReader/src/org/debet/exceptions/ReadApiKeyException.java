package org.debet.exceptions;

public class ReadApiKeyException extends RuntimeException {
	public ReadApiKeyException(String message) {
		super(message);
	}

	public ReadApiKeyException(String message, Throwable cause) {
		super(message, cause);
	}
}
