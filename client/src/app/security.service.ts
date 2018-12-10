import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {User} from './user';
import {HttpClient, HttpHandler, HttpHeaders} from '@angular/common/http';
import {share} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  user$ = new BehaviorSubject<User | null>(null);

  constructor(private http: HttpClient) {
    http.get < User | null > ('/api/currentUser').subscribe(value => this.user$.next(value));
  }

  logout(): Observable<void> {
    const logout$ = this.http.post<void>('/api/logout', {}).pipe(share());
    logout$.subscribe(next => this.user$.next(null));
    return logout$;
  }

  login(username: string, password: string): Observable<User> {
    const headers = new HttpHeaders({
      authorization: 'Basic' + btoa(username + ':' + password),
      'X-Requested-With': 'XMLHttpRequest',
    });

    const login$ = this.http.get<User>('/api/currentUser', {headers}).pipe(share());

    login$.subscribe(
      user => this.user$.next(user),
      () => this.user$.next(null)
    );
    return login$;
  }

  getCurrentUser(): Observable<User|null> {
    return this.user$;
  }
}
