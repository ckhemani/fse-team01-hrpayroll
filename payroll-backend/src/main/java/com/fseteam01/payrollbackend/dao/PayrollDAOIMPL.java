/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: PayrollDAOIMPL - Data Layer for accessing MySQL Database in Cloud.
 */

package com.fseteam01.payrollbackend.dao;
import com.fseteam01.payrollbackend.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PayrollDAOIMPL implements IPayrollDAO{

    //Define field for entity manager
    /*The EntityManager API is used to create and remove persistent entity instances,
        to find entities by their primary key, and to query over entities. */
    private final EntityManager entityManager;

    // Setup Constructor Injection
    @Autowired
    public PayrollDAOIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<Employee> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> myQuery = currentSession.createQuery("from Employee");
        return myQuery.getResultList();
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public Employee findById(int employeeId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Employee.class, employeeId);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void saveOrUpdate(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int computerPartId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee employee = currentSession.get(Employee.class, computerPartId);
        currentSession.delete(employee);
    }
}
