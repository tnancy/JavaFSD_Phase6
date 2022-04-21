import { Component, OnInit } from '@angular/core';
import { Cart } from 'src/app/common/models/cart';
import { CartService } from 'src/app/common/service/cart.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
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
