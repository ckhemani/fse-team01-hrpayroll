/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: IPayrollService - payroll service implementation
 */
package com.fseteam01.payrollbackend.service;

import com.fseteam01.payrollbackend.dao.IPayrollDAO;
import com.fseteam01.payrollbackend.entity.Employee;
import com.fseteam01.payrollbackend.exception.EmployeeNotFoundForDeleteException;
import com.fseteam01.payrollbackend.exception.EmployeeNotFoundForGetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollServiceIMPL implements IPayrollService{
    // Injecting the computer part dao layer
    private final IPayrollDAO payrollDAO;

    @Autowired
    public PayrollServiceIMPL(@Qualifier("payrollDAOIMPL") IPayrollDAO payrollDAO) {
        this.payrollDAO = payrollDAO;
    }

    @Override
    public List<Employee> findAll() {
        return payrollDAO.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        if (payrollDAO.findById(employeeId) == null) {
            throw new EmployeeNotFoundForGetException(employeeId);
        } else {
            return payrollDAO.findById(employeeId);
        }
    }

    @Override
    public void saveOrUpdate(Employee theEmployee) {
        payrollDAO.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteById(int employeeId) {
        if (payrollDAO.findById(employeeId) == null) {
            throw new EmployeeNotFoundForDeleteException(employeeId);
        } else {
            payrollDAO.deleteById(employeeId);
        }
    }
}
