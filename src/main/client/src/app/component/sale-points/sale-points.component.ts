import {Component, OnInit} from '@angular/core';
import {SalePointService} from "../../service/sale-point.service";
import {SalePoint} from "../../model/sale-point";
import {BaseTableComponent} from "../base-component/base-table.component";
import {BaseTableService} from "../../service/base-service/base-table.service";

@Component({
  selector: 'sale-points',
  templateUrl: './sale-points.component.html',
  styleUrls: ['./sale-points.component.css']
})
export class SalePointsComponent extends BaseTableComponent<SalePoint, BaseTableService<SalePoint>> implements OnInit {

  constructor(protected service:SalePointService) {super(service)}

  ngOnInit() {
    this.columns = [
      {field: 'name', header: 'Name'},
      {field: 'address', header: 'Address'},
      {field: 'retailChain', header: 'Retail Chain'},
      {field: 'consultantCount', header: 'Count of consultants'},
    ];
  }

  protected getNewInstance(): SalePoint {
    return new SalePoint();
  }

  public getStyle(row:SalePoint) {
    if (row.consultantCount >= 8 && row.consultantCount <= 10) {
      return 'bg-success';
    }
    if (row.consultantCount > 10) {
      return 'bg-danger';
    }
    return '';
  }


}
