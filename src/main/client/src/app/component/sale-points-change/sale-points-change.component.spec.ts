import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {SalePointsChangeComponent} from './sale-points-change.component';

describe('SalePointsChangeComponent', () => {
  let component: SalePointsChangeComponent;
  let fixture: ComponentFixture<SalePointsChangeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalePointsChangeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalePointsChangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
