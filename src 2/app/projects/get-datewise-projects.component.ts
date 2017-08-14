import {Component, OnInit} from '@angular/core';
import { FormGroup , FormControl} from '@angular/forms';
import {Router} from '@angular/router';
import {ProjectService} from './project.service';
@Component({
  templateUrl: './get-datewise-projects.component.html'
})

export class GetDatewiseProjectsComponent implements OnInit{
  projName;
  projectReport= [];
  projectList= [];
  ProjectNamesFlag = false;
  projectForm = new FormGroup({
    projectName: new FormControl(),
    projectStartDate: new FormControl(),
    projectEndDate: new FormControl()
  });
  constructor(private _projectService: ProjectService , private _router: Router) {
  }
  public getDateWiseProject() {
    this.projName = this.projectForm.value.projectName;
    console.log('adding project');
    console.log(this.projName);
    this._projectService.postRequiredDates(this.projectForm.value.projectName,
      this.projectForm.value.projectStartDate,
      this.projectForm.value.projectEndDate)
      .subscribe(response => this.projectReport = response);
    console.log('project dates posted successfully');
  }
  onClick() {
    this.ProjectNamesFlag = true;
    console.log(this.projectReport);
  }
  ngOnInit() {
this._projectService.getProjectList()
  .subscribe(response => this.projectList = response);
  }
}
