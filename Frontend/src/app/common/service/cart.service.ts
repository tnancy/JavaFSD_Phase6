import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Cart } from '../models/cart';
import { Product } from '../models/product';

@Injectable()
export class CartService {
  cart = new BehaviorSubject<Cart>({ products: [], items: 0, total: 0 });
  products: Product[] = [];

  constructor() { }

  addToCart(product: Product) {
    product.qty = 1;
    const productInCart = this.products.find(p => p.id == product.id);
    if (productInCart) {
      this.products = this.products.filter(p => p.id != product.id);
      product.qty = productInCart.qty + 1;
    }
    this.products = [...this.products, product];
    const items = this.products.reduce((p, c) => p + c.qty, 0);
    const total = this.products.reduce((p, c) => p + c.price, 0);
    this.cart.next({ products: this.products, items, total });
  }

  getCart(): BehaviorSubject<Cart> {
    return this.cart;
  }
}
