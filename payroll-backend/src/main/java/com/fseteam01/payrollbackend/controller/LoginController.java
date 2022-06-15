/*
    FSE Cohort - Team Project 3
    HR Payroll System - Team 1
    Class: LoginController - Controller method for user login
 */
package com.fseteam01.payrollbackend.controller;

import com.fseteam01.payrollbackend.entity.Login;
import com.fseteam01.payrollbackend.exception.PasswordNotValidException;
import com.fseteam01.payrollbackend.service.ILoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:4200"})
@RestController
@RequestMapping("/hrpayroll/api/v1")
public class LoginController {
    private final ILoginService loginService;

    //Constructor Injection: this is telling the spring framework to wire up your
    //dependencies for the PlumbingPartService.
    @Autowired
    public LoginController(@Qualifier("loginServiceIMPL") ILoginService loginService) {
        this.loginService = loginService;
    }

    //This is a POST request for user login.
    //http://localhost:8080/hrpayroll/api/v1/login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login loginInput) {
        //This will call the LoginDaoImpl.findByUserId method to login user
        //through the LoginService
        Login loginRecord = loginService.findByUserId(loginInput.getUserId());
        if (loginRecord.getPassword().equals(loginInput.getPassword()))
            return ResponseEntity.ok(loginRecord);
        else
            throw new PasswordNotValidException(loginInput.getUserId());
    }
}
