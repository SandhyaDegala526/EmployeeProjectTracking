import {Component, OnInit} from '@angular/core';
import {ProjectAllotmentService} from './project-allotment.service';

@Component({
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css']
})

export class ProjectDetailsComponent implements  OnInit {
  projectDetails= [];
  constructor(private _projectAllotmentService: ProjectAllotmentService ) {  }
  ngOnInit() {
     this._projectAllotmentService.getProjectDetails()
        .subscribe(response => this.projectDetails = response);
    }

}
