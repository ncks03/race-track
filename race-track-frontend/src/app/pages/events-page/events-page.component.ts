import { Component } from '@angular/core';
import {RaceEventService} from '../../services/race-event.service';
import {RaceEvent} from '../../interfaces/race-event';

@Component({
  selector: 'rt-events-page',
  imports: [],
  templateUrl: './events-page.component.html',
  styleUrl: './events-page.component.scss'
})
export class EventsPageComponent {

  events?: RaceEvent[];
  error?: Error;

  constructor(private raceEventService: RaceEventService) {
    // Initialize race events
    raceEventService.getAll().subscribe({
      next: (events: RaceEvent[]) => this.events = events,
      error: (error: Error) => this.error = error
    });
  };

  getUpcomingEvents(): RaceEvent[] | null {
    if (this.events) {

      let eventsNotYetPassed = this.events.filter(event => {

        let startDate = event.sessions?.reduce((a, b) => {
          return a.startTime < b.startTime ? a : b;
        }).startTime;

        return startDate >= new Date();
      })

      return eventsNotYetPassed.sort((a, b) => {
        // Get first start time from each event
          let session1 = a.sessions?.reduce((a, b) => a.startTime < b.startTime ? a : b);
          let session2 = b.sessions?.reduce((a, b) => a.startTime < b.startTime ? a : b);

          // Compare start times
          if (session1.startTime > session2.startTime) {
            return 1;
          }

          if (session1.startTime < session2.startTime) {
            return -1;
          }

          return 0;
        }
      ).slice(0, 3);
    }
    return null;
  }
}
