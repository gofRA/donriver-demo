import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ProductsChangeComponent} from './products-change.component';

describe('ProductsChangeComponent', () => {
  let component: ProductsChangeComponent;
  let fixture: ComponentFixture<ProductsChangeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductsChangeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductsChangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
