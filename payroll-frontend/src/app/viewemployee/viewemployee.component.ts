import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {EmployeeService} from '../services/employee.service';
import { Employee } from '../model/employee';

@Component({
  selector: 'app-viewemployee',
  templateUrl: './viewemployee.component.html',
  styleUrls: ['./viewemployee.component.css']
})
export class ViewemployeeComponent implements OnInit {
  employee = new Employee(0);
  msg = "";
  
  constructor(private employeeService : EmployeeService, private route : Router, private activatedRoute : ActivatedRoute) { }

  ngOnInit(): void {
    let paramId = this.activatedRoute.snapshot.paramMap.get('id');
    var id = 0;
    if (paramId)
      id = parseInt(paramId);
    this.employeeService.getAEmployee(id).subscribe(
      data => {this.employee = data;},
      error => console.log("Exception occurred")
    )   
  }

  goList() {
    this.route.navigate(['loginsuccesslanding']);
  }
}
