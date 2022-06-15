/*
  FSE Cohort - Team Project3
  HR Payroll System -Team1
  Class: LoginServiceIMPL - login Service implementation
 */
package com.fseteam01.payrollbackend.service;

import com.fseteam01.payrollbackend.dao.ILoginDAO;
import com.fseteam01.payrollbackend.entity.Login;
import com.fseteam01.payrollbackend.exception.LoginNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceIMPL implements ILoginService {
    // Injecting the login dao layer
    private final ILoginDAO loginDAO;

    @Autowired
    public LoginServiceIMPL(@Qualifier("loginDAOIMPL") ILoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    @Override
    public Login findByUserId(String userId) {
        if (loginDAO.findByUserId(userId) == null) {
            throw new LoginNotFoundException(userId);
        } else {
            return loginDAO.findByUserId(userId);
        }
    }
}
