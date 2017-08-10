import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule} from '@angular/http';
import {FormsModule , ReactiveFormsModule} from '@angular/forms';
import { AddProjectComponent } from './add_project.component';
import {AddProjectService} from './add-project.service';
@NgModule({
  declarations: [
    AddProjectComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [AddProjectService],
  bootstrap: [AddProjectComponent]
})
export class ProjectsModule {}

