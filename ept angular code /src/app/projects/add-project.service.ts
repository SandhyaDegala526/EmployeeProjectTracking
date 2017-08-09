import {Injectable} from '@angular/core';
import {Http, Response , Headers} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class AddProjectService {
  private _urlAddProject: string = 'http://localhost:8080/EmployeeProjectTracking-1.0/addProject';
  constructor(private _http: Http) {
  }
  postProjectData(projectId, projectName)
  {
    const projectData = {
      'projectId': projectId,
      'projectName': projectName
    };
    const headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    return this._http.post(this._urlAddProject, projectData)
      .map((response: Response) => response.json());

  }
}
