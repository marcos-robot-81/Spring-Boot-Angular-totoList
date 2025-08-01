import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})export class DadosService {
    private dados: any = {};


    setDados(dados: any) {
        this.dados = dados;
    }
    getDados() {
        return this.dados;
    }
}