import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Product} from "../model/product";
import {BaseTableService} from "./base-service/base-table.service";

@Injectable()
export class ProductService implements BaseTableService<Product> {

  constructor(private http:HttpClient) {}

  public getItems() {
    return this.http.get(window.location.origin + "/products/");
  }

  public removeItem(id:number) {
    return this.http.delete(window.location.origin + "/products/" + id);
  }

  public updateItem(product:Product) {
    return this.http.put(window.location.origin + "/products/", product);
  }

  public createItem(product:Product) {
    return this.http.post(window.location.origin + "/products/", product);
  }
}
