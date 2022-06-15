import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {EmployeeService} from '../services/employee.service';
import { Employee } from '../model/employee';

@Component({
  selector: 'app-updateemployee',
  templateUrl: './updateemployee.component.html',
  styleUrls: ['./updateemployee.component.css']
})
export class UpdateemployeeComponent implements OnInit {
  employee = new Employee(0);
  msg = "";
  
  constructor(private employeeService : EmployeeService, private route : Router, private activatedRoute : ActivatedRoute) { }

  ngOnInit(): void {
    let paramId = this.activatedRoute.snapshot.paramMap.get('id');
    var id = 0;
    if (paramId)
      id = parseInt(paramId);
    //console.log("URL Param ID: "+id);
    this.employeeService.getAEmployee(id).subscribe(
      data => {this.employee = data;},
      error => console.log("Exception occurred")
    )
  }

  updateEmployee() {
    this.employeeService.updateEmployee(this.employee).subscribe(
      data => { 
        console.log("User Logged in successfully.");
        this.route.navigate(['../loginsuccesslanding'])
      },
      error => {
        console.log("Exception occurred.");
        this.msg = error;
      }
    )    
  }

  goList() {
    this.route.navigate(['loginsuccesslanding']);
  }

}
