import { HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LoginsuccesslandingComponent } from './loginsuccesslanding/loginsuccesslanding.component';
import { HeaderComponent } from './header/header.component';
import { LoginService } from './services/login.service';
import { EmployeeService } from './services/employee.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    LoginsuccesslandingComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    LoginService,
    EmployeeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
