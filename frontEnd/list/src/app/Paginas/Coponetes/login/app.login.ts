import { Component, inject } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { Router } from "@angular/router";
import { DadosService } from "../../menuADT/dados.service";


@Component({
    selector: 'app-login',
    templateUrl: './app.login.html',
    styleUrls: ['./app.login.css'],
    imports: [FormsModule]
})export class AppLogin{
    name: string = '';
    password: string = '';
    DadosService = inject(DadosService);
    aletaS: string = '';
    private router = inject(Router);
    dado: string = '';

    t(){
        let dadot = JSON.parse(this.dado);
        if(dadot.estatos == "1"){            
            this.DadosService.setDados(dadot);
            this.router.navigate([`madt`]);
        }
    }

    login(){
        
        this.aletaS = '';
        if (this.name == ''){
            this.aletaS = "A caixa de emeil esta vazia!";
        }else if(this.password == ''){
            this.aletaS = "A caixa de senha esta vazia!";
        }else if(this.password.length < 8 && this.password != "test"){
            this.aletaS = "Senha deve ter no mínimo 8 caracteres!";
        }else if(this.aletaS == ''){
            this.aletaS = "Aquande o Retono do servidor";

            let Usuario = {name: this.name, password: this.password};

            const req = new XMLHttpRequest();

            req.onreadystatechange = () => {
                if (req.readyState === XMLHttpRequest.DONE) {
                    if (req.status === 200) {
                        //console.log("Login bem-sucedido:", req.responseText); // debug
                        console.log("inicializado");
                        this.dado = (String(req.response));
                        this.t();

                    } else {
                        console.error("Erro ao fazer login:", req.status, req.statusText);
                    }
                }
            };

            req.open("POST", "http://localhost:8080/login",true);

            req.setRequestHeader("Content-Type", "text/plain");

            req.send(`[{"name":"${Usuario.name}","password":"${Usuario.password}"}]`);
            
            
        }
    }

    

}