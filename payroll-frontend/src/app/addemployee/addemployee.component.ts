import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { EmployeeService } from 'src/app/services/employee.service';
import { Employee } from 'src/app/model/employee';

@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrls: ['./addemployee.component.css']
})

export class AddemployeeComponent implements OnInit {

  employees : Employee[] | undefined;
  constructor(private employeeService : EmployeeService, private route : Router) { }

  ngOnInit(): void {
  }

  addEmployee(employeeFirstName: any, employeeLastName: any, employeeJobTitle: any, employeeSalary: any, employeeHomeAddress: any, employeeSSN: any) {
    if(!employeeFirstName || !employeeLastName || !employeeJobTitle || !employeeSalary || !employeeHomeAddress || !employeeSSN) {
      alert("Please add Employee");
    } else{
      this.employeeService.saveEmployee({employeeFirstName,employeeLastName,employeeJobTitle,employeeSalary,employeeHomeAddress,employeeSSN} as unknown as Employee).subscribe(post => {
        console.log(post);
      });
    }
  }

  goList() {
    this.route.navigate(['loginsuccesslanding']);
  }
}