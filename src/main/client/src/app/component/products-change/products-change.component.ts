import {Component, OnInit} from '@angular/core';
import {Product} from "../../model/product";
import {BaseChangeComponent} from "../base-component/base-change.component";

@Component({
  selector: 'products-change',
  templateUrl: './products-change.component.html',
  styleUrls: ['./products-change.component.css']
})
export class ProductsChangeComponent extends BaseChangeComponent<Product> implements OnInit {

  constructor() {super()}

  ngOnInit() {
    this.inputRow = new Product();
  }
}
