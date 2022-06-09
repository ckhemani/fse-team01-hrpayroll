/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: EmployeeNotFoundForGetException - custom exception for getting non-existing object by id
 */
package com.fseteam01.payrollbackend.exception;

import java.text.MessageFormat;

public class EmployeeNotFoundForGetException extends RuntimeException{
    public EmployeeNotFoundForGetException(final int id){
        super(MessageFormat.format("Oops! Could not find employee with id: {0}. Please try another id.", id));
    }
}
