import { Routes } from '@angular/router';
import {HomePageComponent} from './pages/home-page/home-page.component';
import {EventsPageComponent} from './pages/events-page/events-page.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomePageComponent },
  { path: 'events', component: EventsPageComponent}
];
