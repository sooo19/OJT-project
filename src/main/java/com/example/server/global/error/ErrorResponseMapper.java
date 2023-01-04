package com.example.server.global.error;

import com.example.server.global.error.dto.ErrorCode;
import com.example.server.global.error.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponseMapper {

	public static ResponseEntity<ErrorResponse> toErrorResponse(ErrorCode errorCode) {
		return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode));
	}

	public static ResponseEntity<ErrorResponse> toErrorResponse(ErrorCode errorCode, BindingResult bindingResult) {
		return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode, bindingResult));
	}
}
