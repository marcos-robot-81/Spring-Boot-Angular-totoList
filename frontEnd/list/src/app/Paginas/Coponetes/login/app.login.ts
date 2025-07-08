import { Component, inject } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { Router } from "@angular/router";


@Component({
    selector: 'app-login',
    templateUrl: './app.login.html',
    styleUrls: ['./app.login.css'],
    imports: [FormsModule]
})export class AppLogin{
    name: string = '';
    password: string = '';

    aletaS: String = '';
    private router = inject(Router);

    t(){
        if( this.aletaS == "1"){
            this.router.navigate(['madt']);
        }
    }

    login(){
        
        this.aletaS = '';
        if (this.name == ''){
            this.aletaS = "A caixa de emeil esta vazia!";
        }else if(this.password == ''){
            this.aletaS = "A caixa de senha esta vazia!";
        }else if(this.password.length < 8){
            this.aletaS = "Senha deve ter no mínimo 8 caracteres!";
        }else if(this.aletaS == ''){
            this.aletaS = "Aquande o Retono do servidor";

            let Usuario = {name: this.name, password: this.password};

            const req = new XMLHttpRequest();

            req.onreadystatechange = () => {
                if (req.readyState === XMLHttpRequest.DONE) {
                    if (req.status === 200) {
                        //console.log("Login bem-sucedido:", req.responseText); // debug
                        this.aletaS = (String(req.response));
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