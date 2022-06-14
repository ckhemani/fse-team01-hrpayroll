import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {EmployeeService} from '../services/employee.service';

@Component({
  selector: 'app-deleteemployee',
  templateUrl: './deleteemployee.component.html',
  styleUrls: ['./deleteemployee.component.css']
})
export class DeleteemployeeComponent implements OnInit {
  msg = "";
  
  constructor(private employeeService : EmployeeService, private route : Router, private activatedRoute : ActivatedRoute) { }
  ngOnInit(): void {
    let paramId = this.activatedRoute.snapshot.paramMap.get('id');
    var id = 0;
    if (paramId)
      id = parseInt(paramId);
    this.employeeService.deleteEmployee(id).subscribe(
      data => {let msg = "Employee entry has been deleted."; this.route.navigate(['loginsussesslanding']);},
      error => console.log("Exception occurred")
    )
  }

  goList() {
    this.route.navigate(['loginsuccesslanding']);
  }
}
