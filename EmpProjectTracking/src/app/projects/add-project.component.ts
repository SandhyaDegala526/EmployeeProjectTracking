import {Component} from '@angular/core';
import { FormGroup , FormControl , Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ProjectService} from './project.service';
@Component({
  templateUrl: './add-project.component.html'
})

export class AddProjectComponent {
  successFlag;
  failureFlag;
  postError: string;
projectDetails = {
  projectName: '',
  projectStartDate: '',
  projectEndDate: ''
}
constructor(private _projectService: ProjectService , private _router: Router) {
}
public addProject(value) {
  console.log('adding project');
  this.projectDetails.projectName = value.projectName;
  this.projectDetails.projectStartDate = value.projectStartDate;

  this.projectDetails.projectEndDate = value.projectEndDate;
console.log(value.employeeId)
  this._projectService.postProjectData(this.projectDetails)
    .subscribe(response => {
        console.log('response');
        if ( response === true) {
          this.successFlag = true;
        } else {
          this.failureFlag = true;
        }},
      dataError => this.postError = dataError
    );
 /* this.projectForm.reset();*/
  console.log('project details posted successfully');
}
}