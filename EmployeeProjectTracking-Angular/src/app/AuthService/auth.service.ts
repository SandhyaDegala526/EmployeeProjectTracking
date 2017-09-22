import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import 'rxjs/add/operator/filter';
import * as auth0 from 'auth0-js';
import {LoginService} from '../login/login.service';

@Injectable()
export class AuthService {
  userProfile: any;
  auth0 = new auth0.WebAuth({
    clientID: 'JHl7c5o3qa8gvypwqJ1qnjpY25dhdrmu',
    domain: 'sandy526.auth0.com',
    responseType: 'token id_token',
    audience: 'https://sandy526.auth0.com/userinfo',
    redirectUri: 'http://192.168.35.67:4200/home',
    scope: 'openid email profile '
  });
  constructor(public router: Router , private _loginService: LoginService) {}

  public login(): void {
    this.auth0.authorize('');
  }
  public handleAuthentication(): void {
    this.auth0.parseHash((err, authResult) => {
      if (authResult && authResult.accessToken && authResult.idToken) {
        window.location.hash = '';
        this.setSession(authResult);
        console.log('handle authentication in auth0');
/*
       this.router.navigate(['./emp_project_details']);
*/
      } else if (err) {

        this.router.navigate(['/login']);

        console.log('========error in handleAuth in auth0' + err);
      }
    });
  }

  private setSession(authResult): void {
    // Set the time that the access token will expire at
    console.log('set session method in auth0');
    const expiresAt = JSON.stringify((authResult.expiresIn * 1000) + new Date().getTime());
    localStorage.setItem('access_token', authResult.accessToken);
    localStorage.setItem('id_token', authResult.idToken);
    localStorage.setItem('expires_at', expiresAt);
    this._loginService.setSession()
      .subscribe(data => {
        console.log('setSession method in setSession() of auth0 service');
      });
    location.reload();
  }

  public logout(): void {
    // Remove tokens and expiry time from localStorage
    localStorage.removeItem('access_token');
    localStorage.removeItem('id_token');
    localStorage.removeItem('expires_at');
    console.log('logout method in logout() of auth0');

    this._loginService.logout().subscribe(data => {
      console.log('logout method in logout() of auth0');
    });
    // Go back to the home route
    this.router.navigate(['/login']);
  }

  public isAuthenticated(): boolean {
    // Check whether the current time is past the
    // access token's expiry time
    const expiresAt = JSON.parse(localStorage.getItem('expires_at'));
    return new Date().getTime() < expiresAt;
  }

  public getProfile(cb): void {
    const accessToken = localStorage.getItem('access_token');
    if (!accessToken) {
      throw new Error('Access token must exist to fetch profile');
    }

    const self = this;
    this.auth0.client.userInfo(accessToken, (err, profile) => {
      if (profile) {
        self.userProfile = profile;
      }
      cb(err, profile);
    });
  }
}

