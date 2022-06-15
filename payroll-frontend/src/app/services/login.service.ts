import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import { catchError } from 'rxjs/operators';
import {Login} from "../model/login";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private postUrl = "http://localhost:8080/hrpayroll/api/v1/login";

  constructor(private http: HttpClient) { }

  public loginFromRemote(login: Login): Observable<Login> {
    return this.http.post<Login>(this.postUrl, login)
    .pipe(catchError(this.handleError));
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
