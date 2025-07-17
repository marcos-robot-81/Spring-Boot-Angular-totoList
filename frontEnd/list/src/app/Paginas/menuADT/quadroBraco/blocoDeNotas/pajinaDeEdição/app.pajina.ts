import { Component, Input, Output, EventEmitter } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FormGroup } from '@angular/forms';

@Component({
    selector: 'pajina',
    templateUrl:`./app.pajina.html`,
    styleUrls: ["./app.pajina.css"],

}) export class pajina {
    @Input() titulo = '';
    @Input() text = '';
    @Output() saix = new EventEmitter();

    form = new FormGroup({
    tit: new FormControl(''),
    tex: new FormControl(''),
    });


    sai(){
        this.saix.emit();

    }
}

