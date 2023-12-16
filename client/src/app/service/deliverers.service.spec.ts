import { TestBed } from '@angular/core/testing';

import { DeliverersService } from './deliverers.service';

describe('DeliverersService', () => {
  let service: DeliverersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeliverersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
