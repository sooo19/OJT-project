package com.example.server.global.error.exception;

import com.example.server.global.error.dto.ErrorCode;

import java.text.MessageFormat;

public class MemberException extends BusinessException {

	protected MemberException(ErrorCode errorCode, String message) {
		super(errorCode, message);
	}

	protected MemberException(ErrorCode errorCode, String message, Throwable cause) {
		super(errorCode, message, cause);
	}

	public static MemberException notFoundMember(Long memberId) {
		return new MemberException(ErrorCode.NOT_FOUND_MEMBER,
			MessageFormat.format("회원을 찾을 수 없습니다. (medicineId: {0})", memberId));
	}

}

