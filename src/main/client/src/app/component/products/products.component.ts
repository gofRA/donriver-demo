import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {Product} from "../../model/product";
import {BaseTableComponent} from "../base-component/base-table.component";
import {BaseTableService} from "../../service/base-service/base-table.service";

@Component({
  selector: 'products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent extends BaseTableComponent<Product, BaseTableService<Product>> implements OnInit {

  constructor(protected service:ProductService) {super(service)}

  ngOnInit() {
    this.columns = [
      {field: 'name', header: 'Name'},
      {field: 'category', header: 'Category'},
      {field: 'manufacturer', header: 'Manufacturer'},
      {field: 'guarantee', header: 'Guarantee'},
      {field: 'salesCount', header: 'Sales Count'},
      {field: 'totalCount', header: 'Total Count'}
    ];
  }

  protected getNewInstance(): Product {
    return new Product();
  }

}
