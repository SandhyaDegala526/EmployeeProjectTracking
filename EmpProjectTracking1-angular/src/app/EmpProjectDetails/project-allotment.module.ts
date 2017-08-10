import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule} from '@angular/http';
import {FormsModule , ReactiveFormsModule} from '@angular/forms';
import { ProjectAllotmentService } from './project-allotment.service';
import { ProjectAllotmentComponent} from './project-allotment.component';
import {ProjectDetailsComponent} from './project-details.component';
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
  providers: [ProjectAllotmentService],
  bootstrap: [ProjectAllotmentComponent]
})
export class ProjectAllotmentModule {}

