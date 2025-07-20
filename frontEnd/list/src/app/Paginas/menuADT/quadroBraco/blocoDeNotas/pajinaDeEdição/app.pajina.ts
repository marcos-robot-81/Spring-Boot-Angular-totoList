import { Component, Input, Output, EventEmitter } from '@angular/core';
import { FormControl, FormsModule } from '@angular/forms';

@Component({
    selector: 'pajina',
    templateUrl:`./app.pajina.html`,
    styleUrls: ["./app.pajina.css"],
    imports: [ FormsModule ]
}) export class pajina {
    @Input() titulo = "";
    @Input() text = '';
    @Output() saix = new EventEmitter();


    

    sai(){
        const t = {titulo: this.titulo,text: this.text};
        this.saix.emit(t);
    }
}

