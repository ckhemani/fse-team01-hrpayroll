/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: LoginNotFoundException - custom exception for non-existing user login userid
 */
package com.fseteam01.payrollbackend.exception;

import java.text.MessageFormat;
public class LoginNotFoundException extends RuntimeException {
    public LoginNotFoundException(final String userId){
        super(MessageFormat.format("Login failed, could not find user id: {0}", userId));
    }
}
