import {DataTable, MenuItem} from "primeng/primeng";
import {ViewChild} from "@angular/core";
import {BaseTableService} from "../../service/base-service/base-table.service";
import {BaseEntity} from "../../model/base-entity";

export abstract class BaseTableComponent<T extends BaseEntity, S extends BaseTableService<T>> {

  protected columns: any[];
  protected data: T[];
  protected operation:string;

  selectedRow:T;
  modifyingRow:T;
  displayChange:boolean = false;
  menuItems:MenuItem[];

  @ViewChild(DataTable)
  table: DataTable;

  constructor(protected service:S) {
    this.service.getItems().subscribe((data:T[]) => this.data = data);
    this.menuItems = [
      {label: "Modify row", icon: 'fa-edit', command: () => this.editRow()},
      {label: "Delete row", icon: 'fa-close', command: () => this.removeItem()}
    ]
  }

  protected abstract getNewInstance():T;

  private removeItem() {
    let id = this.selectedRow.id;
    this.service.removeItem(id).subscribe(null, null, () => {
      let repIndex = this.data.map(s => s.id).indexOf(id);
      if (~repIndex) {
        this.table.selection = null;
        this.data.splice(repIndex, 1);
        this.data = this.data.slice();
      }
    });
  }


  public addRow() {
    this.modifyingRow = this.getNewInstance();
    this.operation = "Create new";
    this.displayChange = true;
  }

  public editRow() {
    this.modifyingRow = JSON.parse(JSON.stringify(this.selectedRow));
    this.operation = "Edit existing";
    this.displayChange = true;
  }

  public saveEntity(entity:T) {
    if (entity) {
      let id = entity.id;
      if (id) {
        this.service.updateItem(entity).subscribe((data:T) => {
          this.replaceEntity(data);
        });
      } else {
        this.service.createItem(entity).subscribe((data:T) => {
          this.replaceEntity(data);
        });
      }
    }
    this.displayChange = false;
  }

  private replaceEntity(data:T) {
    let repIndex = this.data.map(s => s.id).indexOf(data.id);
    if (~repIndex) {
      this.data.splice(repIndex, 1, data);
    } else {
      this.data.unshift(data)
    }
    //refresh table
    this.data = this.data.slice();
    this.table.selection = data;
  }

}
