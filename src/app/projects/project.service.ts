import {Injectable } from '@angular/core';
import {Http, Response , Headers} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Observable} from 'rxjs/Observable';
@Injectable()
export class ProjectService {
  private _urlAddProject = 'http://192.168.35.67:8080/EmployeeProjectTracking-1.0/project/addProject';
  private _urlGetDateWiseProjects = 'http://192.168.35.67:8080/EmployeeProjectTracking-1.0/project/getDateWiseProjects';
  private _urlGetProjectDurations = 'http://192.168.35.67:8080/EmployeeProjectTracking-1.0/project/getProjectDurations';
  private _urlGetProjectList = 'http://192.168.35.67:8080/EmployeeProjectTracking-1.0/project/getProjectList';
  constructor(private _http: Http) {
  }
  postProjectData(values)
  {
    const projectData = {
      'projectId': values.projectId,
      'projectName': values.projectName,
      'projectStartDate': values.projectStartDate,
      'projectEndDate': values.projectEndDate
    };
    const headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    return this._http.post(this._urlAddProject, projectData)
      .map((response: Response) => response.json());

  }
  postRequiredDates(projectName, projectStartDate, projectEndDate) {
    const projectDates = {
      'projectName': projectName,
      'projectStartDate': projectStartDate,
      'projectEndDate': projectEndDate
    };
    const headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    return this._http.post(this._urlGetDateWiseProjects, projectDates)
      .map((response: Response) => response.json());

  }
  getProjectDurations() {
    return this._http.get(this._urlGetProjectDurations)
      .map((response: Response) => response.json());
  }
  getProjectList() {
    return this._http.get(this._urlGetProjectList)
      .map((response: Response) => response.json());
  }
  _errorHandler(error: Response) {
    console.error(error);
    return Observable.throw(error || 'server error');
  }
}
