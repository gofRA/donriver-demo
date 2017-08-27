import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ProductsComponent} from './component/products/products.component';
import {SalePointsComponent} from './component/sale-points/sale-points.component';
import {LogoutComponent} from './component/logout/logout.component';
import {TabComponent} from './component/tab/tab.component';
import {HttpClientModule} from '@angular/common/http';
import {DatePipe} from "@angular/common";
import 'rxjs/add/operator/map';
//PrimeNG
import {
  ButtonModule,
  ConfirmationService,
  ConfirmDialogModule,
  ContextMenuModule,
  DataTableModule,
  DialogModule,
  InputTextModule,
  PanelModule,
  SharedModule,
  SplitButtonModule,
  TabViewModule
} from 'primeng/primeng';


import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {DropDownMenuComponent} from './component/drop-down-menu/drop-down-menu.component';
import {RouterModule, Routes} from "@angular/router";
import {PanelComponent} from './component/panel/panel.component';
import {ProductService} from "./service/product.service";
import {SalePointService} from "./service/sale-point.service";
import {ProductsChangeComponent} from './component/products-change/products-change.component';
import {SalePointsChangeComponent} from './component/sale-points-change/sale-points-change.component';
import {FormsModule} from '@angular/forms';

export const routes: Routes = [
  {path: '*', component: AppComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    SalePointsComponent,
    LogoutComponent,
    TabComponent,
    DropDownMenuComponent,
    PanelComponent,
    ProductsChangeComponent,
    SalePointsChangeComponent
  ],
  imports: [
    BrowserModule,
    TabViewModule,
    DataTableModule,
    SharedModule,
    ButtonModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(routes),
    DialogModule,
    ConfirmDialogModule,
    PanelModule,
    HttpClientModule,
    ContextMenuModule,
    InputTextModule,
    FormsModule
  ],
  providers: [
    ConfirmationService,
    ProductService,
    SalePointService,
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
