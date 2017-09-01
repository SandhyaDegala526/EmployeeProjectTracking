import {Injectable} from '@angular/core';
import {Http, Response, Headers} from '@angular/http';
import {URLConstant} from '../constants/urlconstant';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class EmployeeService {
  private _urlAddEmployee = URLConstant.EPT_URL + 'employee/addEmployee';

  constructor(private _http: Http) {
  }

  postEmployeeData(employee) {
    const employeeData = {
      'employeeId': employee.employeeId,
      'employeeName': employee.employeeName,
      'employeeState': employee.employeeState
    };
    const headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    return this._http.post(this._urlAddEmployee, employeeData, headers)
      .map((response: Response) => response.json());

  }

}
