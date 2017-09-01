import {Component, OnInit} from '@angular/core';
import {EmployeeProjectService} from './employee-project.service';

@Component({
  templateUrl: './project-details.component.html'
})

export class ProjectDetailsComponent implements  OnInit {
  projectDetails= [];
  constructor(private _projectAllotmentService: EmployeeProjectService ) {  }
  ngOnInit() {
     this._projectAllotmentService.getProjectDetails()
        .subscribe(response => this.projectDetails = response);
    }

}
