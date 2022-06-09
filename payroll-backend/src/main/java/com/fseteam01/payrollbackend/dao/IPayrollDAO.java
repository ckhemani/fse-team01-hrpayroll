package com.fseteam01.payrollbackend.dao;

import com.fseteam01.payrollbackend.entity.Employee;

import java.util.List;

public interface IPayrollDAO {
    List<Employee> findAll();
    Employee findById(int employeeID);
    void saveOrUpdate(Employee employee);
    void deleteById(int employeeID);
}
