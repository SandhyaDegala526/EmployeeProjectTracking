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
  ProjectNamesFlag;
  ProjectNamesFlag1;
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
    console.log('given values ' + this.projectForm);
   this.ProjectNamesFlag = false;
    this.ProjectNamesFlag1 = false;
    this._projectService.postRequiredDates(this.projectForm.value.projectName,
      this.projectForm.value.projectStartDate,
      this.projectForm.value.projectEndDate)
      .subscribe(response => {this.projectReport = response
    console.log(this.projectReport.length);
    if (this.projectReport.length > 0 && this.projectReport != null) {
      this.ProjectNamesFlag = true;
    } else {
      this.ProjectNamesFlag1 = true;
    }
    });
    console.log(this.projectReport.length);
    console.log('project dates posted successfully');
  }
  ngOnInit() {
this._projectService.getProjectList()
  .subscribe(response => this.projectList = response);
  }
}
