package com.fseteam01.payrollbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "password")
    private String password;

    // default constructor
    public Login() {
    }

    // param constructor
    public Login(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    // getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ToString
    @Override
    public String toString() {
        return "Login{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
