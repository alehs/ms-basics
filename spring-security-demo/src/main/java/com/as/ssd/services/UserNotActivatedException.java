package com.as.ssd.services;

public class UserNotActivatedException extends RuntimeException {
	public UserNotActivatedException(String message) {
		super(message);
	}
}
