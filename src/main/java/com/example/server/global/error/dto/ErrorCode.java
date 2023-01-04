package com.example.server.global.error.dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {

	// Common
	INVALID_METHOD_ARGUMENT("C001", "Invalid method argument", HttpStatus.BAD_REQUEST),
	UNKNOWN_SERVER_ERROR("C002", "Unknown server error", HttpStatus.INTERNAL_SERVER_ERROR),
	METHOD_NOT_ALLOWED("C003", "Http method not allowed", HttpStatus.METHOD_NOT_ALLOWED),

	// Member
	NOT_FOUND_MEMBER("M001", "Not found member", HttpStatus.BAD_REQUEST),

	// Post
	NOT_FOUND_POST("P001", "Not found post", HttpStatus.BAD_REQUEST);

	private final String code;
	private final String message;
	private final HttpStatus httpStatus;

	ErrorCode(String code, String message, HttpStatus httpStatus) {
		this.code = code;
		this.message = message;
		this.httpStatus = httpStatus;
	}
}
