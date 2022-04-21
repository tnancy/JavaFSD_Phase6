import { Component, Input, OnInit } from '@angular/core';
import { Cart } from 'src/app/common/models/cart';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  @Input() cart: Cart = { products: [], items: 0, total: 0 }

  constructor() { }

  ngOnInit(): void {
  }
}
