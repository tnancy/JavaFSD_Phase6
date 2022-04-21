import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Product } from '../common/models/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  @Input() products: Product[] = [];
  @Input() admin: boolean = false;
  selectedProduct: Product = {
    id: 0,
    name: '',
    category: '',
    price: 0,
    cuisine: '',
    description: '',
    qty: 0,
    img: '',
  }
  @Output() newCartItemEvent = new EventEmitter();
  @Output() deleteProduct = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  selectProduct(product: Product) {
    this.selectedProduct = product;
  }

}
