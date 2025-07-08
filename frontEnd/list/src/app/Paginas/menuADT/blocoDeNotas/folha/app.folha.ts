import { Component,input } from "@angular/core";

@Component({
 selector :"folha",
 template: `
    <p>{{titulo}}</p>
    <p>{{texto}}</p>
 
 `,
 styles:"",

}) export class Folha {
    titulo = input<String>();
    texto = input<String>();
}