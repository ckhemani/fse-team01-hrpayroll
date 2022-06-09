package com.fseteam01.payrollbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private int employeeId;

    @Column(name = "employeeFirstName")
    private String employeeFirstName;

    @Column(name = "employeeLastName")
    private String employeeLastName;

    @Column(name = "employeeJobTitle")
    private String employeeJobTitle;

    @Column(name = "employeeSalary")
    private String employeeSalary;

    @Column(name = "employeeHomeAddress")
    private String employeeHomeAddress;

    @Column(name = "employeeSSN")
    private String employeeSSN;

//    Default Constructor
    public Employee(){}

//    Para Constructor
    public Employee(int employeeId, String employeeFirstName, String employeeLastName, String employeeJobTitle, String employeeSalary, String employeeHomeAddress, String employeeSSN) {
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeeJobTitle = employeeJobTitle;
        this.employeeSalary = employeeSalary;
        this.employeeHomeAddress = employeeHomeAddress;
        this.employeeSSN = employeeSSN;
    }

//    Getter and Setters

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeJobTitle() {
        return employeeJobTitle;
    }

    public void setEmployeeJobTitle(String employeeJobTitle) {
        this.employeeJobTitle = employeeJobTitle;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeHomeAddress() {
        return employeeHomeAddress;
    }

    public void setEmployeeHomeAddress(String employeeHomeAddress) {
        this.employeeHomeAddress = employeeHomeAddress;
    }

    public String getEmployeeSSN() {
        return employeeSSN;
    }

    public void setEmployeeSSN(String employeeSSN) {
        this.employeeSSN = employeeSSN;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", employeeJobTitle='" + employeeJobTitle + '\'' +
                ", employeeSalary='" + employeeSalary + '\'' +
                ", employeeHomeAddress='" + employeeHomeAddress + '\'' +
                ", employeeSSN='" + employeeSSN + '\'' +
                '}';
    }
}
