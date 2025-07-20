import { Component, Input, Output, EventEmitter} from "@angular/core";
import { FormsModule } from "@angular/forms";

@Component({
    selector: 'windowAddBloco',
    template: `
        <div id="caixa"> 
            <div id="box">
                <h4>Nome do Títolo</h4> <h4 id='x' (click)="sai()">x</h4>
                <input type="text" [(ngModel)]="x"  /> 
                <input type="button" value="Cria" (click)="Cria()" />

            </div>
        </div>    `,
    styles: [`
            #caixa{
                z-index: 3000;
                width: calc(100vw - 20px);
                height: calc(100vh - 60px);
                margin-top: -16px;
                margin auto;
                background: rgba(189, 189, 189, 0.5);
                position: absolute ;
                display: grid;
            }
            #box{
                margin: auto;
                display: grid;
                width: 280px;
                height:100px;
                background: rgb(62, 0, 104);
                border:6px;
            }
            #box input{
                margin:auto;
                height:20px;
                width:200px
            }
            h4{
                margin:auto;
                color: white;
            }
            #x{
                position: absolute;
                margin-left:265px;
            }

        `],
    imports:[FormsModule]
})export class windowsAddBloco{
    @Output() xsai = new EventEmitter<boolean>();
    @Output() xcria = new EventEmitter<String>();
    x = ''

    Cria(){
        if(this.x.length > 0){
        this.xcria.emit(this.x)
        }else{
            window.alert("O valor esta nulo")
        }
    }
    sai(){
        this.xsai.emit(false);
    }
}

// --------------------------------------------------------------------------

@Component({
    selector: 'windowAddfolha',
    template: `
    <div id="caixa"> 
            <div id="box">
                <h4>Nome do folhar</h4> <h4 id='x' (click)="sai()">x</h4>
                <input type="text" [(ngModel)]="x"  /> 
                <input type="button" value="Cria" (click)="Cria()" />

            </div>
        </div>   
    `,
     styles: [`
            #caixa{
                z-index: 3000;
                width: calc(100vw - 20px);
                height: calc(100vh - 60px);
                margin-top: -16px;
                margin auto;
                background: rgba(189, 189, 189, 0.5);
                position: absolute ;
                display: grid;
            }
            #box{
                margin: auto;
                display: grid;
                width: 280px;
                height:100px;
                background: rgb(62, 0, 104);
                border:6px;
            }
            #box input{
                margin:auto;
                height:20px;
                width:200px
            }
            h4{
                margin:auto;
                color: white;
            }
            #x{
                position: absolute;
                margin-left:265px;
            }

        `],
    imports:[FormsModule]
})export class windowsAddFolha{
    @Output() xsai = new EventEmitter<boolean>();
    @Output() xcria = new EventEmitter();
    x = ''

    Cria(){
        if(this.x.length > 0){
        this.xcria.emit(String(this.x))
        }else{
            window.alert("O valor esta nulo")
        }
    }
    sai(){
        this.xsai.emit(false);
    }
}
