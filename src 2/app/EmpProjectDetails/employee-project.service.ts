import {Injectable} from '@angular/core';
import {Http, Response , Headers} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class EmployeeProjectService {
  private _urlAssignProject: string = 'http://localhost:8080/EmployeeProjectTracking-1.0/assignProject';
  private _urlProjectDetails: string = 'http://localhost:8080/EmployeeProjectTracking-1.0/projectAssignList';
  private _urlNotAssignedEmployees: string= 'http://localhost:8080/EmployeeProjectTracking-1.0/getNotAssignedEmployees';
  private _urlEmployeeRoles: string= 'http://localhost:8080/EmployeeProjectTracking-1.0/employeeRoles';
  constructor(private _http: Http) {
  }
  postProjectAllotmentData(employeeId, employeeName, projectName, employeeStartDate, employeeEndDate, employeeRole) {
    const projectAllotmentData = {
      'employeeId': employeeId,
      'employeeName': employeeName,
      'projectName': projectName,
      'employeeStartDate': employeeStartDate,
      'employeeEndDate': employeeEndDate,
      'employeeRole': employeeRole
    };
    const headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    return this._http.post(this._urlAssignProject, projectAllotmentData)
      .map((response: Response) => response.json());

  }
  getProjectDetails() {
    return this._http.get(this._urlProjectDetails)
      .map((response: Response) => response.json());
      /*.catch(this._errorHandler)*/
  }
  getNotAssignedEmployees() {
    return this._http.get(this._urlNotAssignedEmployees)
      .map((response: Response) => response.json());
  }
  getEmployeeRoles() {
    return this._http.get(this._urlEmployeeRoles)
      .map((response: Response) => response.json());
  }
  _errorHandler(error: Response) {
    console.error(error);
    return Observable.throw(error || 'server error');
  }
}
