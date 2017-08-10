import {Component} from '@angular/core';
import { FormGroup , FormControl} from '@angular/forms';
import {Router} from '@angular/router';
import {AddProjectService} from './add-project.service';
@Component({
  templateUrl: './add_project.component.html'
})

export class AddProjectComponent {
  projectDetails= [];
projectForm = new FormGroup({
  projectId: new FormControl(),
  projectName: new FormControl(),
  projectStartDate: new FormControl(),
  projectEndDate: new FormControl()
});
constructor(private _projectService: AddProjectService , private _router: Router) {
}
public addProject()
{
  console.log('adding project');
  this._projectService.postProjectData(this.projectForm.value.projectId,
    this.projectForm.value.projectName,
    this.projectForm.value.projectStartDate,
    this.projectForm.value.projectEndDate)
    .subscribe(response => this.projectDetails = response);
  console.log('project details posted successfully');
}
}
