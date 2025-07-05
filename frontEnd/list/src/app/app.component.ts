import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AppMenu } from './Paginas/Coponetes/Menu/app.menu';



@Component({
  selector: 'app-root',
  imports: [AppMenu],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'list';

  
}
