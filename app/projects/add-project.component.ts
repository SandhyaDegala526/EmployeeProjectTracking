import {Component} from '@angular/core';
import { FormGroup , FormControl , Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ProjectService} from './project.service';
@Component({
  templateUrl: './add-project.component.html'
})

export class AddProjectComponent {
   flag= false;
  postError: string;
projectForm = new FormGroup({
  projectId: new FormControl(),
  projectName: new FormControl(),
  projectStartDate: new FormControl(),
  projectEndDate: new FormControl()
});
constructor(private _projectService: ProjectService , private _router: Router) {
}
public addProject()
{
  console.log('adding project');
  this._projectService.postProjectData(this.projectForm.value.projectId,
    this.projectForm.value.projectName,
    this.projectForm.value.projectStartDate,
    this.projectForm.value.projectEndDate)
    .subscribe(response => {
        console.log('response');
        if ( response !== null) {
          this.flag = true;
        }
      },
      dataError => this.postError = dataError
    );
  this.projectForm.reset();
  console.log('project details posted successfully');
}
  getMessage() {
    this.flag = true;
}
}
