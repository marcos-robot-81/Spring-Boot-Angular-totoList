package com.example.demo.Login;

import com.example.demo.Login.TrafereciaDeDados.DadosT;
import com.example.demo.Login.TrafereciaDeDados.V_altenticado;
import com.example.demo.card.Dados;
import com.example.demo.dbAll.Usuario;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GService {

    private final UsuarioService usuarioService;
    private final DadosService DadosService;

    @Autowired
    public GService(UsuarioService usuarioService, DadosService dadosService) {
        this.usuarioService = usuarioService;
        this.DadosService = dadosService;
    }

    // Valida usuario
    public String validado(String usuariox){
        //Criado ussuario para a comparação
        Usuario uso = new Usuario();
        //set valores do ussario
        {
            int t1,t2,t3;
            t1 = usuariox.indexOf("name");
            t2 = usuariox.indexOf("password");
            t3 = usuariox.length();
            uso.setAll((usuariox.substring(t1+7,t2-3)),usuariox.substring(t2+11,t3-3));
        }
        List<Usuario> ListUsuarios = (usuarioService.buscarPorNome(uso.getNome()));
        for(int i = 0;i < ListUsuarios.size();i++){
            if(  (  (uso.getNome()).equals(ListUsuarios.get(i).getNome()) ) && ((uso.getPassword()).equals(ListUsuarios.get(i).getPassword()) ) ){
                V_altenticado val = new V_altenticado();
                DadosT dadosT = new DadosT(val.criaChavi(ListUsuarios.get(i)));
                // cria adcionameto de dados
                dadosT.setDados(DadosService.getDados(dadosT.getIdUse()));
                dadosT.setEstatus("1");
                Gson gson = new Gson();
                return gson.toJson(dadosT);
            }
        }
        return "0" ;
    }
    public String cadastraUsuario(Usuario uso){
        List<Usuario> ListUsuarios = (usuarioService.buscarPorNome(uso.getNome()));
        for(int i = 0;i < ListUsuarios.size();i++) {
            if (((uso.getNome()).equals(ListUsuarios.get(i).getNome()))) {
                return "escolha outro nome.";

            }
        }
        uso.setId(""+(ListUsuarios.size()));
        usuarioService.criaUsuario(uso);
        DadosService.CriaDadosUse(uso.getId());
        return "ok";
    }
    public boolean AtualizaDados(String text){
        Gson gson = new Gson();
        DadosT dadosT = gson.fromJson(text, DadosT.class);
        DadosService.AtualiaDados(dadosT.getDados());
        return true;
    }
    public String seve(String caraquiteres){
        Gson gson = new Gson();
        DadosT dadosT = gson.fromJson(caraquiteres, DadosT.class);

        

        return "0";
    }


}
