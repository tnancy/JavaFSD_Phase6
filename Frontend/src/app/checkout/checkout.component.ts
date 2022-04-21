import { Component, OnInit } from '@angular/core';
import { Cart } from '../common/models/cart';
import { Product } from '../common/models/product';
import { CartService } from '../common/service/cart.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  cart: Cart = { products: [], items: 0, total: 0 }

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.getCart();
  }

  getCart() {
    this.cartService.getCart().subscribe((products: any) => {
      this.cart = products;
    });
  }

}
