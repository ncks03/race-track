import { Injectable } from '@angular/core';
import {RaceEvent} from '../interfaces/race-event';
import {Observable, of} from 'rxjs';
import {v4 as uuidv4} from 'uuid';


@Injectable({
  providedIn: 'root'
})
export class RaceEventService {

  events: RaceEvent[] = [
    {
      name: 'CrowdStrike 24 hours of Spa Francorchamps',
      track: 'Spa Francorchamps',
      country: 'Belgium',
      sessions: [
        {
          uuid: uuidv4(),
          sessionType: 'Qualifying',
          startTime: new Date(2025, 6, 27, 21, 30)
        },
        {
          uuid: uuidv4(),
          sessionType: 'Race',
          startTime: new Date(2025, 6, 28, 16, 30)
        }
      ]
    }
  ];

  constructor() { }

  get(uuid: number): Observable<RaceEvent> {
    let foundEvent = this.events.find(event => event.uuid ?? null === uuid);

    if (!foundEvent) {
      throw new Error('No event was found');
    }

    return of(foundEvent);
  }
}
