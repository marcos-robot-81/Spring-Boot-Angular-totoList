import { Component, inject } from "@angular/core"
import { AriaDetrabalho } from "./quadroBraco/app.adt"
import { pajina } from "./quadroBraco/blocoDeNotas/pajinaDeEdição/app.pajina";
import { FormsModule } from "@angular/forms";
import { windowsAddBloco, windowsAddFolha } from "./quadroBraco/blocoDeNotas/addBloco/app.aadb";
import { Router } from "@angular/router";


interface Folha {
    id: number;
    titulo: string;
    texto: string;
}

interface Bloco {
    id: number;
    titulo: string;
    folhas: Folha[];
}


@Component({
    selector: 'app-menu-adt',
    templateUrl: './app.madt.html',
    styleUrls: ['./app.madt.css'],
    imports: [AriaDetrabalho, pajina, FormsModule, windowsAddBloco, windowsAddFolha],
})
export class AppMenuADT {
    blocoAtual = '';
    idBlocoAtual = 0;
    indiceBloco = 0;
    paginaSelecionada = -1;
    controleAdicionarB = false;
    controleAdicionarF = false;

   
    blocos: Bloco[] = [];

    

    

    deletarFolha(idFolha: number) {
        let arrayTemp = this.blocos[this.indiceBloco].folhas;
        let transferencia = [];
        for (let i = 0; i < arrayTemp.length; i++) {
            if (arrayTemp[i].id != idFolha) {
                if (i > idFolha) {
                    transferencia[i - 1] = arrayTemp[i];
                    transferencia[i - 1].id = i - 1;
                } else {
                    transferencia[i] = arrayTemp[i];
                }
            }
        }
        this.blocos[this.indiceBloco].folhas = transferencia;
    }

    deletarBloco() {
        if (this.blocoAtual == '') {
            window.alert("Bloco não selecionado")
        } else {
            let arrayTemp = this.blocos;
            let transferencia = [];
            if (this.blocos.length <= 1) {
                this.blocos = [];
                this.indiceBloco = 0;
                this.blocoAtual = "Deletado";
            } else {
                for (let i = 0; i < this.blocos.length; i++) {
                    if (i != this.indiceBloco) {
                        if (i > this.indiceBloco) {
                            transferencia[i - 1] = arrayTemp[i];
                            transferencia[i - 1].id = i - 1;
                        } else {
                            transferencia[i] = arrayTemp[i];
                        }
                    }
                }
                this.blocos = transferencia;
                this.indiceBloco = 0;
                this.idBlocoAtual = 0;
                this.blocoAtual = "Deletado";
            }
        }
    }

    selecionarBloco(id: number) {
        if (this.paginaSelecionada == -1) {
            this.idBlocoAtual = id;
            this.indiceBloco = this.blocos.findIndex(item => item.id == id)
            this.blocoAtual = this.blocos[this.indiceBloco].titulo;
        } else {
            window.alert("Você irá perder todos os dados, por favor clique em sair")
        }
    }

    abrirPagina(id: number) {
        this.paginaSelecionada = id;
    }

    salvarPagina(t: { titulo: string, text: string }) {
        this.blocos[this.indiceBloco].folhas[this.paginaSelecionada].titulo = t.titulo;
        this.blocos[this.indiceBloco].folhas[this.paginaSelecionada].texto = t.text;
        this.paginaSelecionada = -1;
    }

    novablocod(v: boolean) {
        this.controleAdicionarB = v;
    }
    
    novobloco(n: String){
            
            let b = {id: this.blocos.length+1, titulo: ""+n, folhas: []};
            this.blocos[this.blocos.length] = b;
            this.novablocod(false);
    }
    novafolhad(v: boolean){
        this.controleAdicionarF = v;
    }

    novafolha(n: string){
        let v = {titulo: ""+n ,texto: "", id: this.blocos[this.indiceBloco].folhas.length }
        if(this.idBlocoAtual > 0){
        this.blocos[this.indiceBloco].folhas[
            this.blocos[this.indiceBloco].folhas.length
        ] = v;
        this.controleAdicionarF = false;
        }else{
            window.alert("Selecione um bloco")
        }
    }

}