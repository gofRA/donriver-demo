export interface BaseTableService<T> {
  getItems();
  removeItem(id:number);
  updateItem(item:T);
  createItem(item:T);
}
