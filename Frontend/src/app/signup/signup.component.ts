import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../common/models/user';
import { AuthService } from '../common/service/auth.service';

const baseUrl = "http://localhost:8080/api/addUser"

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  errorMessage = ''

  signupForm = this.formBuilder.group({
    username: '',
    password: '',
    email: ''
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

    const b64Pass = btoa(`${this.signupForm.value.username}:${this.signupForm.value.password}`)
    const authHeader = `Basic ${b64Pass}`

    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: authHeader
      })
    }

    const user = {
    username: this.signupForm.value.username,
    password: this.signupForm.value.password,
    email: this.signupForm.value.email
      
    }

    this.httpClient.post<User>(baseUrl, user)
    .subscribe({
      next: res => this.authService.setUser(res),
      error: err => this.errorMessage = err.error.message,
      complete: () => this.router.navigate(['/login'])
    }
    )
  }
}
