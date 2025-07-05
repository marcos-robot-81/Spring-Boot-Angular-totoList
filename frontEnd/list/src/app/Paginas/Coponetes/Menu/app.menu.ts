import { Component } from '@angular/core';
import {RouterOutlet ,RouterLink} from '@angular/router';



@Component({
    selector: 'app-menu',
    templateUrl: './app.menu.html',
    styleUrls: ['./app.menu.css'],
    imports: [RouterOutlet ,RouterLink]
})export class AppMenu {

};