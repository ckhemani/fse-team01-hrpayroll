/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: ILoginDAO - login DAO interface
 */
package com.fseteam01.payrollbackend.dao;

import com.fseteam01.payrollbackend.entity.Login;

public interface ILoginDAO {
    Login findByUserId(String userId);
}
