import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/primeng";

@Component({
  selector: 'drop-down-menu',
  templateUrl: './drop-down-menu.component.html',
  styleUrls: ['./drop-down-menu.component.css']
})
export class DropDownMenuComponent implements OnInit {

  items:MenuItem [];
  display: boolean = false;
  content: string;

  constructor() { }

  ngOnInit() {
    let self = this;
    this.items = [
      {label: "First item", command: function() {
        self.showConfirmation(this.label);
      }},
      {label: "Second item", command: function () {
        self.showConfirmation(this.label);
      }},
      {label: "Last item", command: function() {
        self.showConfirmation(this.label);
      }}];
  }

  private showConfirmation(text:string) {
    this.content = text + " has been activated";
    this.display = true;
  }
}
