/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: EmployeeNotFoundForDeleteException - custom exception for deleting non-existing object by id
 */
package com.fseteam01.payrollbackend.exception;

import java.text.MessageFormat;

public class EmployeeNotFoundForDeleteException extends RuntimeException{
    public EmployeeNotFoundForDeleteException(final int id){
        super(MessageFormat.format("Oops! Could not find employee with id: {0} for deletion. Please try another id.", id));
    }
}
