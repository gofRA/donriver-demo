import {Component, OnInit} from '@angular/core';
import {DataTable} from "primeng/primeng";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-panel',
  templateUrl: './panel.component.html',
  styleUrls: ['./panel.component.css']
})
export class PanelComponent implements OnInit {

  private tableToExport: DataTable;
  private title:string;

  constructor(private pipe:DatePipe) { }

  ngOnInit() {
    this.title = "ISP National APHT Report: " + this.pipe.transform(new Date(), 'dd MMMM yyyy');
  }

  public saveTable(table:DataTable) {
    this.tableToExport = table;
  }

  public exportReport(){
    this.tableToExport.exportFilename = this.title;
    this.tableToExport.exportCSV();
  }
}
