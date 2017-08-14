import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule} from '@angular/http';
import {FormsModule , ReactiveFormsModule} from '@angular/forms';
import { EmployeeProjectService } from './employee-project.service';
import { ProjectAllotmentComponent} from './project-allotment.component';
import {ProjectDetailsComponent} from './project-details.component';
import {ProjectService} from '../projects/project.service';
@NgModule({
  declarations: [
    ProjectAllotmentComponent,
    ProjectDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [EmployeeProjectService , ProjectService],
  bootstrap: [ProjectAllotmentComponent]
})
export class ProjectAllotmentModule {}

