package com.example.demo.Login;

import com.example.demo.Login.TrafereciaDeDados.Cabesario;
import com.example.demo.Login.TrafereciaDeDados.V_altenticado;
import com.example.demo.dbAll.Usuario;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GService {

    private final UsuarioService usuarioService;
    private final DadosService DadosService;
    private final ChaveService chaveService;

    @Autowired
    public GService(UsuarioService usuarioService, DadosService dadosService,ChaveService chaveService) {
        this.usuarioService = usuarioService;
        this.DadosService = dadosService;
        this.chaveService = chaveService;
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
                val.criaChavi(ListUsuarios.get(i));
                Cabesario dadosT = new Cabesario(val.getChaveC());
                // cria adcionameto de dados
                dadosT.setConteudo(DadosService.getDados(ListUsuarios.get(i).getId()));
                dadosT.setEstatus("1");
                chaveService.newChave(val.getChave());
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
        Cabesario dadosT = gson.fromJson(text, Cabesario.class);
        DadosService.AtualiaDados(dadosT.getConteudo());
        return true;
    }
    public String seve(String caraquiteres){
        Gson gson = new Gson();
        caraquiteres = caraquiteres.replace("\\","");
        caraquiteres = caraquiteres.substring(1,caraquiteres.length()-1);
        Cabesario dadosT =  gson.fromJson(caraquiteres, Cabesario.class);

        if( chaveService.verificaChavaAtiva(dadosT.getCredenciais())){
            DadosService.AtualiaDados(dadosT.getConteudo());
            return "1";
        }

        return "0";
    }


}
