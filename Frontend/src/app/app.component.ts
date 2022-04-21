import { Component } from '@angular/core';
import { CartService } from './common/service/cart.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [CartService]
})
export class AppComponent {
  title = 'FOODBOX';
}
