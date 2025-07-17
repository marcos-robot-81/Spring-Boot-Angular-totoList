import { Component, Input, Output, EventEmitter} from "@angular/core";
import { Folha } from "./blocoDeNotas/folha/app.folha";


@Component({
    selector: 'app-aria-detrabalho',
    templateUrl: './app.adt.html',
    styleUrls: ['./app.adt.css'],
    imports: [Folha],
})
export class AriaDetrabalho {
    sele = -1;
    @Input() folhas: any;
    @Input() DeleteFolha: any;
    @Output() XDeleteFolha = new EventEmitter<number>()
    @Output() folhaSelec = new EventEmitter<number>()

    receberId(id: Number){
        this.sele = Number(id);
        this.folhaSelec.emit(Number(id)); 
    }
    
    deletafolha(id: Number){
        this.XDeleteFolha.emit(Number(id));
    }
    

}