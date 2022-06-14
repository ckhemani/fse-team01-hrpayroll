import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import { catchError } from 'rxjs/operators';
import {Employee} from "../model/employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private getAllUrl = "http://localhost:8080/hrpayroll/api/v1/retrieveAllEmployees";
  private getAUrl = "http://localhost:8080/hrpayroll/api/v1/retrieveAEmployee";
  private postUrl = "http://localhost:8080/hrpayroll/api/v1/addAEmployee";
  private putUrl = "http://localhost:8080/hrpayroll/api/v1/updateAEmployee";
  private deleteUrl = "http://localhost:8080/hrpayroll/api/v1/deleteAEmployee";

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.getAllUrl}`);
  }

  getAEmployee(id: number): Observable<Employee>{
    const url = `${this.getAUrl}/${id}`;
    return this.http.get<Employee>(url);
  }

  saveEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.postUrl, employee);
  }

  updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(this.putUrl, employee);
  }

  deleteEmployee(id: number): Observable<any> {
    const url = `${this.deleteUrl}/${id}`;
    return this.http.delete<any>(url);
  }

  private handleError(httpError: HttpErrorResponse) {
    if (httpError.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', httpError.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${httpError.status}, ` +
        `body was: ${httpError.error}`);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error(httpError.error.message));
  }
}
