/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: ILoginService - login Service interface
 */
package com.fseteam01.payrollbackend.service;

import com.fseteam01.payrollbackend.entity.Login;

public interface ILoginService {
    Login findByUserId(String userId);
}
