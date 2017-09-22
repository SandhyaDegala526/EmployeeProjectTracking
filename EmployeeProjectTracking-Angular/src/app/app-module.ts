import { BrowserModule, Title } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HttpModule } from '@angular/http';
import { LoginModule} from './login/login.module';
import { HomepageModule} from './homepage/homepage.module';
import {AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {AuthGuard} from './authguard';
import {AuthService} from './AuthService/auth.service';
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    AppRoutingModule,
    LoginModule,
    HomepageModule
  ],
  providers: [AuthGuard, Title , AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }


