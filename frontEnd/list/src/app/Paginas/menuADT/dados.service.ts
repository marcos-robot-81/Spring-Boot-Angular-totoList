import { Injectable } from "@angular/core";

interface Bloco {
    id: number;
    titulo: string;
    folhas: Folha[];
}
interface Folha {
    id: number;
    titulo: string;
    texto: string;
}

@Injectable({
  providedIn: 'root'
})export class DadosService {
    static setBlocos(blocos: Bloco[]) {
        throw new Error("Method not implemented.");
    }
    static setDados(dados: any) {
        throw new Error("Method not implemented.");
    }
    static SalvarDadosServer() {
        throw new Error("Method not implemented.");
    }
    private dados: any = {};
    private chave: string = "";

    setDados(dados: any) {
        this.dados = dados;
        this.chave = dados.chave || '';
    }
    getDados() {
        return this.dados;
    }
    setBlocos(blocos: any) {
        this.dados.conteudo.dados = blocos;
        console.log(this.dados);
    }

    getDadosServer(chava:string){
        const req = new XMLHttpRequest();
        req.onreadystatechange = () => {
            if (req.readyState === XMLHttpRequest.DONE) {
                if (req.status === 200) {
                    this.dados = JSON.parse(req.responseText);
                    console.log("Dados recebidos do servidor:", this.dados);
                    this.dados = JSON.parse(String(req.response))
                } else {
                    console.error("Erro ao obter dados do servidor:", req.status, req.statusText);
                }
            }
        };
        req.open("GET", "http://localhost:8080/dados/get", true);
        req.setRequestHeader("Content-Type", "text/plain");
        req.send(`[{"chave":"${chava}"}]`);
    }

    SalvarDadosServer() {
        const req = new XMLHttpRequest();
        req.onreadystatechange = () => {
            if (req.readyState === XMLHttpRequest.DONE) {
                if (req.status === 200) {
                    console.log("server");
                    console.log("Dados salvos no servidor:", req.responseText);
                } else {
                    console.error("Erro ao salvar dados no servidor:", req.status, req.statusText);
                }
            }
        };
        let mesagem = JSON.stringify(this.dados);
        req.open("POST", "http://localhost:8080/dados/salva", true);
        req.setRequestHeader("Content-Type", "text/plain");
        req.send((JSON.stringify(mesagem)));
    }

}