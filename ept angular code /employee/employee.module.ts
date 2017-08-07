import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule} from '@angular/forms';
import { AddEmployeeComponent } from './add_employee.component';
import {EmployeeService} from './employee.service';
@NgModule({
  declarations: [
    AddEmployeeComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule
  ],
  providers: [EmployeeService],
  bootstrap: [AddEmployeeComponent]
})
export class EmployeeModule {}


