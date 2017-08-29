import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AddEmployeeComponent } from './add-employee.component';
import {EmployeeService} from './add-employee.service';
@NgModule({
  declarations: [
    AddEmployeeComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [EmployeeService ],
  bootstrap: [AddEmployeeComponent]
})
export class EmployeeModule {}


