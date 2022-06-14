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

  constructor(private employeeService: EmployeeService, private route : Router) { }
  
  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe((data: Employee[]) => {
      console.log(data);
      this.employees = data;
    });
  }

  goAddEmployee() {
    this.route.navigate(["/addemployee"]);
  }

  goUpdateEmployee(id: number) {
    this.route.navigate(["/updateemployee", id]);
  }

  goViewEmployee(id: number) {
    this.route.navigate(["/viewemployee", id]);
  }

  goDeleteEmployee(id: number) {
    this.route.navigate(["/deleteemployee", id]);
  }
}
