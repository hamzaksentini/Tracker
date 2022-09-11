import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const API_URL = 'http://localhost:8082/api/accounts/';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) {
  }

  getAccounts(): Observable<Array<any>> {
    return this.http.get<Array<any>>(API_URL);
  }

  getAccount(accountId: any): Observable<Array<any>> {
    return this.http.get<Array<any>>(API_URL + accountId);
  }

  deposit(amount: any, label: any, accountId: any): Observable<any> {
    return this.http.put(API_URL + 'deposit', {
      accountId,
      amount,
      label
    }, httpOptions);
  }

  withdraw(amount: any, label: any, accountId: any): Observable<any> {
    return this.http.put(API_URL + 'withdraw', {
      accountId,
      amount,
      label
    }, httpOptions);
  }
}
