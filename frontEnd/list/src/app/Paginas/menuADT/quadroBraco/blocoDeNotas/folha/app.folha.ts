import { Component,Input, Output, EventEmitter } from "@angular/core";

@Component({
 selector :"folha",
 template: `


<div (click)="sele()"  id="{{indicado}}">
        <nav>
        @if(titulo.length >= 16){
            <h4>{{titulo.slice(0,16)+"..."}}</h4>
        }@else{
            <h4>{{titulo}}</h4>
        }
        <p id="x" (click)="XMeDeletar(); $event.stopPropagation()" >X</p>

    </nav>
    @if(texto.length >= 373){
        <p id="text" >{{texto.slice(0,333)+"..."}}</p>
    }@else{
        <p id="text" >{{texto.slice(0,373)}}</p>
    }
</div>

 `,
 styles:`
    
    div{
        width: 250px;
        height: 350px;
        border: 1px solid black;
        border-radius: 15px 0px 15px 15px;
        margin-top:13px;
        margin-left: 25px;
        position: relative;
    }
    nav{
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #f0f0f0;
        padding: 10px;
        border-bottom: 1px solid #ccc;
        height: 20px;
        border-radius: 15px 0px 0px 0px;
        
    }
    nav h4{
        margin-left: 10px;
    }
    div p{
        margin: 10px;
        
    }
    #text{
        overflow-wrap: break-word;
    }
    #c{
        box-shadow:5px 5px 5px rgba(0,0,0,1);
        
    }
    #x{
        border: 1px solid black;
        padding: 2px 8px 2px 8px;
        border-radius: 6px;
    }
 `,

}) export class Folha {
    @Input() titulo: String = "Titulo";
    @Input() texto: String = "Texto da folha";
    @Input() id: String = "null";
    @Input() indicado: String = "";
    @Output() celeção = new EventEmitter();
    @Output() MeDeletar = new EventEmitter();

    sele(){
        this.celeção.emit(this.id);
    }
    XMeDeletar(){
        this.MeDeletar.emit(this.id);
    }
}