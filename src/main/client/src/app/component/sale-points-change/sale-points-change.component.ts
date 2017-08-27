import {Component, OnInit} from '@angular/core';
import {SalePoint} from "../../model/sale-point";
import {BaseChangeComponent} from "../base-component/base-change.component";

@Component({
  selector: 'sale-points-change',
  templateUrl: './sale-points-change.component.html',
  styleUrls: ['./sale-points-change.component.css']
})
export class SalePointsChangeComponent extends BaseChangeComponent<SalePoint>  implements OnInit{

  constructor(){super()}

  ngOnInit() {
    this.inputRow = new SalePoint();
  }

}
