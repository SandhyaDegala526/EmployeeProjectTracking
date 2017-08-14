import {Injectable} from '@angular/core';
import {Http, Response , Headers} from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
@Injectable()
export class EmployeeService {
  private _urlAddEmployee: string = 'http://localhost:8080/EmployeeProjectTracking-1.0/addEmployee';

  constructor(private _http: Http) {
  }

  postEmployeeData(employeeId, employeeName, employeeState) {
    const employeeData = {
      'employeeId': employeeId,
      'employeeName': employeeName,
      'employeeState': employeeState
    };
    const headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    console.log('employee service method');
    return this._http.post(this._urlAddEmployee, employeeData)
      .map((response: Response) => response.json());

  }

}
