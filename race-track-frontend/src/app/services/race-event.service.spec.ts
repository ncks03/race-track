import { TestBed } from '@angular/core/testing';

import { RaceEventService } from './race-event.service';

describe('RaceEventService', () => {
  let service: RaceEventService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RaceEventService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
