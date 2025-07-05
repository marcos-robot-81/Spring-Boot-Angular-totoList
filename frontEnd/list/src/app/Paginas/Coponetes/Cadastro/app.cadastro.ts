import { Component } from "@angular/core";
import { FormsModule } from "@angular/forms";



@Component({
    selector: 'app-cadastro',
    templateUrl: './app.cadastro.html',
    styleUrls: ['./app.cadastro.css'],
    standalone: true,
    imports: [FormsModule]
}) export class AppCadastro {
    name: string = ''; // Email
    password: string = '';
    password2: string = '';
    alertaMensagem: String = '';
    cadastrar() {
        this.alertaMensagem = '';
        if (this.name == ''){
            this.alertaMensagem += "A caixa de e-mail está vazia! </br>";
        }else if(this.password == ''){
            this.alertaMensagem += "A caixa de senha está vazia!";
        }else if(this.password.length < 8){
            this.alertaMensagem += "Senha deve ter no mínimo 8 caracteres!";
        }else if(this.password != this.password2){
            this.alertaMensagem += "As senhas não conferem!";
        }else if(this.alertaMensagem == ''){
            this.alertaMensagem = "Aguardando o retorno do servidor";
            // Aqui você pode adicionar a lógica para redirecionar o usuário ou realizar outras ações após o login bem-sucedido.
            let Usuario = {name: this.name, password: this.password};

            const req = new XMLHttpRequest();

            req.onreadystatechange = () => {
                if (req.readyState === XMLHttpRequest.DONE) {
                    if (req.status === 200) {
                        //console.log("Login bem-sucedido:", req.responseText);
                        this.alertaMensagem = ( String(req.response));
                    } else {
                        console.error("Erro ao fazer login:", req.status, req.statusText);
                    }
                }
            };

            req.open("POST", "http://localhost:8080/cadastro",true);

            req.setRequestHeader("Content-Type", "text/plain");

            req.send(`[{"name":"${Usuario.name}","password":"${Usuario.password}"}]`);
            
            
        }
    }
}