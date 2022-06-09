/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: IPayrollService - payroll service interface
 */
package com.fseteam01.payrollbackend.service;
import com.fseteam01.payrollbackend.entity.Employee;

import java.util.List;

public interface IPayrollService {
    List<Employee> findAll();
    Employee findById(int employeeId);
    void saveOrUpdate(Employee theEmployee);
    void deleteById(int employeeId);
}
