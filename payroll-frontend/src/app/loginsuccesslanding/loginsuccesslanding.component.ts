import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {EmployeeService} from '../services/employee.service';
import { Employee } from '../model/employee';

@Component({
  selector: 'app-loginsuccesslanding',
  templateUrl: './loginsuccesslanding.component.html',
  styleUrls: ['./loginsuccesslanding.component.css']
})
export class LoginsuccesslandingComponent implements OnInit {
  employees: Employee[] | undefined;

  constructor(private employeeService: EmployeeService) { }
  
  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe((data: Employee[]) => {
      console.log(data);
      this.employees = data;
    });
  }

}
