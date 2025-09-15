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
      name: 'Qatar 1812KM',
      track: 'Lusail Circuit',
      country: 'Qatar',
      sessions: [
        {
          uuid: uuidv4(),
          sessionType: 'Free Practice 1',
          startTime: new Date(2025, 2, 26, 9, 30)
        }
      ]
    },
    {
      name: '6 Hours of Imola',
      track: 'Autodromo Enzo e Dino Ferrari',
      country: 'Italy',
      sessions: [
        {
          uuid: uuidv4(),
          sessionType: 'Free Practice 1',
          startTime: new Date(2025, 4, 18, 11, 15)
        }
      ]
    },
    {
      name: 'TotalEnergies 6 Hours of Spa-Francorchamps',
      track: 'Circuit de Spa-Francorchamps',
      country: 'Belgium',
      sessions: [
        {
          uuid: uuidv4(),
          sessionType: 'Free Practice 1',
          startTime: new Date(2025, 5, 8, 11, 30)
        }
      ]
    },
    {
      name: '24 Hours of Le Mans',
      track: 'Circuit de la Sarthe',
      country: 'France',
      sessions: [
        {
          uuid: uuidv4(),
          sessionType: 'Free Practice 1',
          startTime: new Date(2025, 6, 11, 14, 0)
        }
      ]
    },
    {
      name: 'Rolex 6 Hours of Sao Paulo',
      track: 'Interlagos',
      country: 'Brazil',
      sessions: [
        {
          uuid: uuidv4(),
          sessionType: 'Free Practice 1',
          startTime: new Date(2025, 6, 11, 16, 0)
        }
      ]
    },
    {
      name: 'Lone Star Le Mans',
      track: 'Circuit of the Americas',
      country: 'United States',
      sessions: [
        {
          uuid: uuidv4(),
          sessionType: 'Free Practice 1',
          startTime: new Date(2025, 9, 5, 18, 30)
        }
      ]
    },
    {
      name: '6 Hours of Fuji',
      track: 'Fuji international Circuit',
      country: 'Japan',
      sessions: [
        {
          uuid: uuidv4(),
          sessionType: 'Free Practice 1',
          startTime: new Date(2025, 9, 26, 3, 15)
        }
      ]
    },
    {
      name: 'Bapco Energies 8 Hours of Bahrain',
      track: 'Bahrain Circuit',
      country: 'Bahrain',
      sessions: [
        {
          uuid: uuidv4(),
          sessionType: 'Free Practice 1',
          startTime: new Date(2025, 11, 6, 10, 15)
        }
      ]
    },
    {
      name: 'Formula 1 Qatar Airways Azerbaijan Grand Prix 2025',
      track: 'Baku City Circuit',
      country: 'Azerbaijan',
      sessions: [
        {
          uuid: uuidv4(),
          sessionType: 'Free Practice 1',
          startTime: new Date(2025, 9, 19, 10, 30)
        }
      ]
    },
    {
      name: 'Formula 1 Singapore Airlines Singapore Grand Prix 2025',
      track: 'Marina Bay Street Circuit',
      country: 'Singapore',
      sessions: [
        {
          uuid: uuidv4(),
          sessionType: 'Free Practice 1',
          startTime: new Date(2025, 10, 3, 11, 30)
        }
      ]
    },
    {
      name: 'ELMS 4 Hours of Spa',
      track: 'Circuit de Spa Francorchamps',
      country: 'Belgium',
      sessions: [
        {
          uuid: uuidv4(),
          sessionType: 'Free Practice',
          startTime: new Date(2025, 7, 22, 21, 30)
        },
        {
          uuid: uuidv4(),
          sessionType: 'Qualifying',
          startTime: new Date(2025, 7, 23, 14, 30)
        },
        {
          uuid: uuidv4(),
          sessionType: 'Race',
          startTime: new Date(2025, 7, 24, 13, 0)
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

  getAll(): Observable<RaceEvent[]> {
    let foundEvents: RaceEvent[] = this.events;

    return of(foundEvents);
  }
}
