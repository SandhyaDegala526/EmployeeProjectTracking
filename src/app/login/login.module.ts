
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule} from '@angular/forms';
import {LoginComponent} from './login.component';
import {LoginService} from './login.service';
@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule
  ],
  providers: [LoginService],
  bootstrap: [LoginComponent]
})
export class LoginModule { }
