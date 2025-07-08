import { Routes } from '@angular/router';
import { AppSomo } from './Paginas/OqueSomos/app.somo';
import { AppLoginCadastro } from './Paginas/loginECadastroRotas/app.logincatro';
import { AppLogin } from './Paginas/Coponetes/login/app.login';
import { AppCadastro } from './Paginas/Coponetes/Cadastro/app.cadastro';
import { AppMenu } from './Paginas/Coponetes/Menu/app.menu';
import { AriaDetrabalho } from './Paginas/menuADT/AriaDetrabalho/app.adt';
import { AppMenuADT } from './Paginas/menuADT/app.madt';

export const routes: Routes = [
    {
        path: '',
        title: 'Home',
        component: AppSomo
    },
    {
        path: 'entre',
        title: 'Entre',
        
        component: AppLoginCadastro,
        children: [
            {
            path: '',
            redirectTo: 'login',
            pathMatch: 'full'
            },
            {
            path: 'cadastro',
            title: 'Entra/Cadastro',
            component: AppCadastro
            },
            {
                path: 'login',
                title: 'Entra/Login',
                component: AppLogin,
            }
        ]
    },
    {
        path:'madt',
        title: 'BlocosDeNotas',
        component: AppMenuADT,
    }
];
