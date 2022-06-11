import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LoginsuccesslandingComponent } from './loginsuccesslanding/loginsuccesslanding.component';

const routes: Routes = [
  {path:'', component:LoginComponent},
  {path:'loginsuccesslanding', component:LoginsuccesslandingComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
