import {Component, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {ProductsComponent} from "../products/products.component";
import {SalePointsComponent} from "../sale-points/sale-points.component";
import {DataTable} from "primeng/primeng";

@Component({
  selector: 'tabs',
  templateUrl: './tab.component.html',
  styleUrls: ['./tab.component.css']
})
export class TabComponent implements OnInit {

  @Output() tableToExport: EventEmitter<DataTable> = new EventEmitter();

  index:number;

  @ViewChild(ProductsComponent)
  products: ProductsComponent;

  @ViewChild(SalePointsComponent)
  salePoints: SalePointsComponent;

  tabs:any;

  constructor() { }

  ngOnInit() {
    this.tabs = [this.salePoints, this.products];
    this.tableToExport.emit(this.tabs[0].table);
  }

  public saveTable(event) {
    this.tableToExport.emit(this.tabs[event.index].table);
  }

}
