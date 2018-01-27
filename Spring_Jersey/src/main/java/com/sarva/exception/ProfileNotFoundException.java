package com.sarva.exception;

public class ProfileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7466822317205316382L;

	public ProfileNotFoundException(String message) {
		super(message);
	}

}
