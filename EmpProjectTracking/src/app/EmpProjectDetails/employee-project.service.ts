import {Injectable} from '@angular/core';
import {Http, Response , Headers} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class EmployeeProjectService {
  private _urlAssignProject = 'http://192.168.35.67:8080/EmployeeProjectTracking-1.0/projectAllocation/assignProject';
  private _urlProjectDetails = 'http://192.168.35.67:8080/EmployeeProjectTracking-1.0/projectAllocation/getProjectAssignList';
  private _urlNotAssignedEmployees = 'http://192.168.35.67:8080/EmployeeProjectTracking-1.0/employee/getNotAssignedEmployees';
  private _urlEmployeeRoles = 'http://192.168.35.67:8080/EmployeeProjectTracking-1.0/employeeRoles/getEmployeeRoles';

  constructor(private _http: Http) {
  }
  postProjectAllotmentData(employeeId,  projectName, employeeStartDate, employeeEndDate, employeeRole) {
    const projectAllotmentData = {
      'employeeId': employeeId,
      'projectId': projectName,
      'employeeStartDate': employeeStartDate,
      'employeeEndDate': employeeEndDate,
      'emproleId': employeeRole
    };
    const headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    return this._http.post(this._urlAssignProject, projectAllotmentData)
      .map((response: Response) => response.text());

  }
  getProjectDetails() {
    return this._http.get(this._urlProjectDetails)
      .map((response: Response) => response.json());
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
