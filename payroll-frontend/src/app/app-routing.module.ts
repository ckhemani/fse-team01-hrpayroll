import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LoginsuccesslandingComponent } from './loginsuccesslanding/loginsuccesslanding.component';
import { UpdateemployeeComponent } from './updateemployee/updateemployee.component';
import { ViewemployeeComponent } from './viewemployee/viewemployee.component';
import { DeleteemployeeComponent } from './deleteemployee/deleteemployee.component';
import { AddemployeeComponent } from './addemployee/addemployee.component';

const routes: Routes = [
  {path:'', component:LoginComponent},
  {path:'loginsuccesslanding', component:LoginsuccesslandingComponent},
  {path:'updateemployee/:id', component:UpdateemployeeComponent},
  {path:'updateemployee', component:UpdateemployeeComponent},
  {path:'viewemployee/:id', component:ViewemployeeComponent},
  {path:'viewemployee', component:ViewemployeeComponent},
  {path:'deleteemployee/:id', component:DeleteemployeeComponent},
  {path:'addemployee', component:AddemployeeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
