import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AddEmployeeComponent } from './add-employee.component';
import {EmployeeService} from './add-employee.service';
import {EmployeeStatusService} from './employee-status.service';
import {EmployeeStatusComponent} from './employee-status.component';

@NgModule({
  declarations: [
    AddEmployeeComponent,
    EmployeeStatusComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [EmployeeService , EmployeeStatusService],
  bootstrap: [AddEmployeeComponent]
})
export class EmployeeModule {}


