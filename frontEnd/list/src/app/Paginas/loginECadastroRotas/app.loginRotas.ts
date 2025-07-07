import { Routes } from '@angular/router';
import { AppLogin } from '../Coponetes/login/app.login';
import { AppCadastro } from '../Coponetes/Cadastro/app.cadastro';

export const routesLoginC: Routes = [
    {
        path: 'cadastro',
        title: 'Entra/Cadastro',
        component: AppCadastro
    },
    {
        path: 'login',
        title: 'Entra/Login',
        component: AppLogin,
    },
]
