import { Component } from "@angular/core"
import { AriaDetrabalho } from "./quadroBraco/app.adt"
import { pajina } from "./quadroBraco/blocoDeNotas/pajinaDeEdição/app.pajina";

@Component({
    selector: 'app-menu-adt',
    templateUrl: './app.madt.html',
    styleUrls: ['./app.madt.css'],
    imports: [AriaDetrabalho, pajina],
})
export class AppMenuADT {
    blocoAtual = '';
    idBlocoAtual = 0;
    psbloco = 0;
    paginaS = -1;


    blocos = [
        {
            id: 1, Title: "Titulo 1", folahas: [
                { titulo: "impostos", texto: "Cria um text sobre a criação de impostos", id: 0 },
                { titulo: "Lei 11/240", texto: "E crime plaplapla", id: 1 },
                { titulo: "Lei 12/250", texto: "E crime plaplapla", id: 2 },
                { titulo: "Lei 13/260", texto: "E crime plaplapla", id: 3 },
                { titulo: "Lei 14/270", texto: "E crime plaplapla", id: 4 },
                { titulo: "Lei 15/280", texto: "E crime plaplapla", id: 5 },
            ]
        },
        {
            id: 2, Title: "Titulo 2", folahas: [
                { titulo: "impostos2", texto: "Cria um text sobre a criação de impostos", id: 0 },
                { titulo: "Lei 62/290", texto: "E crime plaplapla", id: 2 },
                { titulo: "Lei 64/210", texto: "E crime plaplapla", id: 3 },
                { titulo: "Lei 65/250", texto: "E crime plaplapla", id: 4 },
                { titulo: "Lei 66/220", texto: "E crime plaplapla", id: 5 },
            ]
        }, {
            id: 3, Title: "test", folahas: [
                { titulo: "impostos2", texto: "Cria um text sobre a criação de impostos", id: 0 },

            ]
        }
    ]

    deletaFolha(idFolha: number) {
        let arraytemp = this.blocos[this.psbloco].folahas;
        let traferecia = [];
        for (var i = 0; i < arraytemp.length; i++) {
            if (arraytemp[i].id != idFolha) {
                if (i > idFolha) {
                    traferecia[i - 1] = arraytemp[i];
                    traferecia[i - 1].id = i - 1;
                } else {
                    traferecia[i] = arraytemp[i];
                }
            }
        }
        this.blocos[this.psbloco].folahas = traferecia;
    }

    deletabloco() {
        if (this.blocoAtual == '') {
            window.alert("Bloco não celecionado")
        } else {
            let arraytemp = this.blocos;
            let traferecia = [];
            if (this.blocos.length <= 1) {
                this.blocos = [{
                    id: 1, Title: "New", folahas: []
                }];
                this.psbloco = 0;
                this.blocoAtual = "Deletado";
            } else {
                for (var i = 0; i < this.blocos.length; i++) {
                    if( i != this.psbloco){
                    if ( i > this.psbloco) {
                        traferecia[i - 1] = arraytemp[i];
                        traferecia[i - 1].id = i - 1;
                    } else{
                        traferecia[i] = arraytemp[i];
                    }
                }
            }
                this.blocos = traferecia;
                this.psbloco = 0;
                this.blocoAtual = "Deletado";
            }
        }
    }

    celecinaBloco(id: number) {
        this.idBlocoAtual = id;
        this.psbloco = (this.blocos.findIndex(item => item.id == id))
        this.blocoAtual = this.blocos[this.psbloco].Title;
        this.paginaS = -1;   
    }

    
    abriPagina(id: number) {
        this.paginaS = id;
    }
    salvaPagina(titulo: String, text:String){
        this.blocos[this.psbloco].folahas[this.paginaS].titulo = ''
        this.blocos[this.psbloco].folahas[this.paginaS].texto = ''

    }

}