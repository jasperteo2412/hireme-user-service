package com.hireme.user.exception;

public class TutorServiceException extends RuntimeException {
    public TutorServiceException(String message) {
        super(message);
    }

    public TutorServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
