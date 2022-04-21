import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from '../models/product';
import { AuthService } from './auth.service';

const baseUrl = 'http://localhost:8080/api'

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  model = 'menu'

  constructor(private http: HttpClient,
    private authService: AuthService) { }

  getAll() {
    return this.http.get(`${baseUrl}/${this.model}`)
  }

  deleteProduct(id: number) {
    const user = this.authService.user;
    const b64Pass = btoa(`${user.username}:${user.password}`)
    const authHeader = `Basic ${b64Pass}`

    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: authHeader
      })
    }
    this.http.delete(`${baseUrl}/products/${id}`, httpOptions)
      .subscribe(res => console.log('product deleted'));
  }
}
