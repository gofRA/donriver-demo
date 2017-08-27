import {inject, TestBed} from '@angular/core/testing';

import {SalePointService} from './sale-point.service';

describe('SalePointService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SalePointService]
    });
  });

  it('should be created', inject([SalePointService], (service: SalePointService) => {
    expect(service).toBeTruthy();
  }));
});
