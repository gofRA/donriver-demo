import {EventEmitter, Input, Output} from "@angular/core";

export class BaseChangeComponent<T> {

  @Input()
  inputRow:T;
  @Input()
  display:boolean;
  @Input()
  operation:string;
  @Output()
  outputRow:EventEmitter<T> = new EventEmitter();

  constructor() { }

  public save() {
    this.outputRow.emit(this.inputRow);
  }

  public cancel() {
    this.outputRow.emit(null);
  }
}
