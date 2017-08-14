import { NgModule } from '@angular/core';
import { RouterModule , Routes } from '@angular/router';
import {HomepageComponent} from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard} from './authguard';

const routes: Routes =
  [ {path: '', redirectTo : '/login', pathMatch : 'full'},
    {path: 'login', component: LoginComponent},
  ];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}
