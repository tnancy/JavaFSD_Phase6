import { Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  user: User = null as any;

  constructor() { }

  isLoggedIn(): boolean {
    return this.user != null;
  }

  setUser(user: User) {
    this.user = user;
  }
}
