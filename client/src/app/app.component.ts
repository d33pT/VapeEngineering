import {Component} from '@angular/core';
import {SecurityService} from './security.service';
import {Observable} from 'rxjs';
import {User} from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'herbie';
  user: User | null;

  constructor(private security: SecurityService) {
    this.security.getCurrentUser().subscribe(u => this.user = u);
  }

  loginAsMichi() {
    this.security.login('Michi', 'Test');
  }

  logout() {
    this.security.logout();
  }

}
