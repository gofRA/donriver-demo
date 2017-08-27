import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SalePoint} from "../model/sale-point";
import {BaseTableService} from "./base-service/base-table.service";

@Injectable()
export class SalePointService implements BaseTableService<SalePoint>{

  constructor(private http:HttpClient) { }

  public getItems() {
    return this.http.get(window.location.origin + "/sale_points/");
  }

  public removeItem(id:number) {
    return this.http.delete(window.location.origin + "/sale_points/" + id);
  }

  public updateItem(salePoint:SalePoint) {
    return this.http.put(window.location.origin + "/sale_points/", salePoint);
  }

  public createItem(salePoint:SalePoint) {
    return this.http.post(window.location.origin + "/sale_points/", salePoint);
  }
}
