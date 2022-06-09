/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: ApplicationExceptionHandler - incorporate exceptions in HTTP response
 */
package com.fseteam01.payrollbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
@SuppressWarnings("unused")
public class ApplicationExceptionHandler {
    @ResponseStatus(
            value = HttpStatus.NOT_FOUND)
    //reason = "Requested Part Not Found")
    @ExceptionHandler(EmployeeNotFoundForGetException.class)
    public ResponseEntity<ApiError> handleException(EmployeeNotFoundForGetException e) {
        ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }

    @ResponseStatus(
            value = HttpStatus.INTERNAL_SERVER_ERROR)
    //reason = "Requested Part Not Found")
    @ExceptionHandler(EmployeeNotFoundForDeleteException.class)
    public ResponseEntity<ApiError> handleException(EmployeeNotFoundForDeleteException e) {
        ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }

    @ResponseStatus(
            value = HttpStatus.INTERNAL_SERVER_ERROR)
    //reason = "Requested login Not Found")
    @ExceptionHandler(LoginNotFoundException.class)
    public ResponseEntity<ApiError> handleException(LoginNotFoundException e) {
        ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }

    @ResponseStatus(
            value = HttpStatus.INTERNAL_SERVER_ERROR)
    //reason = "Invalid password")
    @ExceptionHandler(PasswordNotValidException.class)
    public ResponseEntity<ApiError> handleException(PasswordNotValidException e) {
        ApiError apiError = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(apiError, apiError.getHttpStatus());
    }
}
