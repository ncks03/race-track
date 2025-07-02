import {RaceSession} from './race-session';

export interface RaceEvent {
  uuid?: string,
  name: string,
  track: string,
  country: string,
  sessions: RaceSession[]
}
