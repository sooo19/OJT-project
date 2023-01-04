package com.example.server.global.error.exception;

import com.example.server.global.error.dto.ErrorCode;

import java.text.MessageFormat;

public class PostException extends BusinessException {

    protected PostException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    protected PostException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public static PostException notFoundPost(Long postId) {
        return new PostException(ErrorCode.NOT_FOUND_POST,
                MessageFormat.format("게시물을 찾을 수 없습니다. (postId: {0})", postId));
    }

}
