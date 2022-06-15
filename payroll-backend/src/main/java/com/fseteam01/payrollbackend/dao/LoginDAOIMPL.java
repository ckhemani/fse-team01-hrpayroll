/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: LoginDAOIMPL - login DAO implementation
 */
package com.fseteam01.payrollbackend.dao;

import com.fseteam01.payrollbackend.entity.Login;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class LoginDAOIMPL implements ILoginDAO{
    //Define field for entity manager
    /*The EntityManager API is used to create and remove persistent entity instances,
        to find entities by their primary key, and to query over entities. */
    private final EntityManager entityManager;

    //Set up constructor injection
    @Autowired
    public LoginDAOIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public Login findByUserId(String userId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Login.class, userId);
    }
}
