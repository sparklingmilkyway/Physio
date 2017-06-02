import { TestBed, inject } from '@angular/core/testing';

import { PraxisService } from './praxis.service';

describe('PraxisService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PraxisService]
    });
  });

  it('should ...', inject([PraxisService], (service: PraxisService) => {
    expect(service).toBeTruthy();
  }));
});
