import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CheckoutComponent } from './checkout/checkout.component';
import { OrderDetailsComponent } from './checkout/order-details/order-details.component';
import { PaymentComponent } from './checkout/payment/payment.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LoginGuard } from './login/login.guard';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  { path: 'checkout', component: CheckoutComponent, canActivate: [LoginGuard] },
  { path: 'pay', component: PaymentComponent, canActivate: [LoginGuard] },
  { path: 'confirmation', component: OrderDetailsComponent, canActivate: [LoginGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent},
  { path: '', component: HomeComponent, canActivate: [LoginGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }
