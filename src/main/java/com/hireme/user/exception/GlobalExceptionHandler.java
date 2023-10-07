package com.hireme.user.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TutorServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleTutorServiceException(TutorServiceException ex) {
        return new ErrorResponse("Tutor Service Error", ex.getMessage());
    }

    // Add more exception handlers for different exceptions if needed
}
