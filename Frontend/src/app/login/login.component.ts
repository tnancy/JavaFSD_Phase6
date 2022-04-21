import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../common/models/user';
import { AuthService } from '../common/service/auth.service';

const baseUrl = "http://localhost:8080/api/login"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  errorMessage = ''

  loginForm = this.formBuilder.group({
    username: '',
    password: ''
  })

  constructor(
    private formBuilder: FormBuilder,
    private httpClient: HttpClient,
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  handleSubmit() {
    this.errorMessage = ''

    const b64Pass = btoa(`${this.loginForm.value.username}:${this.loginForm.value.password}`)
    const authHeader = `Basic ${b64Pass}`

    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: authHeader
      })
    }

    this.httpClient.get<User>(baseUrl, httpOptions)
      .subscribe({
        next: res => this.authService.setUser(res),
        error: err => this.errorMessage = err.error.message,
        complete: () => this.router.navigate(['/'])
      }
      )
  }

}
