import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from '../model/login';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userLogin = new Login();
  msg = ''; 
  constructor(private loginService : LoginService, private afterLoginRoute : Router) { }

  ngOnInit(): void {
  }

  login() {
    this.loginService.loginFromRemote(this.userLogin).subscribe(
      data => { 
        console.log("User Logged in successfully.");
        this.afterLoginRoute.navigate(['../loginsuccesslanding'])
      },
      error => {
        console.log("Exception occurred.");
        this.msg = error;
      }
    )
  }
}
