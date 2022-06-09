/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: LoginNotFoundException - custom exception for invalid user login password
 */
package com.fseteam01.payrollbackend.exception;

import java.text.MessageFormat;

public class PasswordNotValidException extends RuntimeException{
    public PasswordNotValidException(final String userId){
        super(MessageFormat.format("Login failed for {0}, invalid password.", userId));
    }
}
