package com.example.demo.Login;

import com.example.demo.Login.TrafereciaDeDados.Cabesario;
import com.example.demo.config.TokenService;
import com.example.demo.dbAll.Usuario;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class GService {

    private final UsuarioService usuarioService;
    private final DadosService DadosService;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public GService(
        UsuarioService usuarioService,
        DadosService dadosService,
        TokenService tokenService,
        PasswordEncoder passwordEncoder
    ) {
        this.usuarioService = usuarioService;
        this.DadosService = dadosService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    // Valida usuario
    public String validado(String usuariox) {
        Gson gson = new Gson();
        Usuario uso = null;
        try {
            // Log para debug
            System.out.println("Recebido para login: " + usuariox);
            
            if (usuariox.trim().startsWith("[")) {
                Usuario[] usos = gson.fromJson(usuariox, Usuario[].class);
                if (usos != null && usos.length > 0) {
                    uso = usos[0];
                }
            } else {
                uso = gson.fromJson(usuariox, Usuario.class);
            }
        } catch (Exception e) {
            System.out.println("Erro ao processar JSON de login: " + e.getMessage());
            return "0";
        }
        
        if (uso == null || uso.getName() == null) {
            System.out.println("Usuário ou nome nulo após parsing");
            return "0";
        }
        
        Usuario userFound = usuarioService.buscarPorNome(uso.getName());
        
        if (userFound != null && passwordEncoder.matches(uso.getPassword(), userFound.getPassword())) {
            String token = tokenService.generateToken(userFound.getName());
            
            Cabesario dadosT = new Cabesario(token);
            dadosT.setConteudo(DadosService.getDados(userFound.getId()));
            dadosT.setEstatus("1");
            
            String response = gson.toJson(dadosT);
            System.out.println("Login bem-sucedido para: " + uso.getName());
            return response;
        }
        
        System.out.println("Falha no login para: " + uso.getName());
        return "0";
    }

    public String cadastraUsuario(Usuario uso) {
        Usuario userFound = usuarioService.buscarPorNome(uso.getName());
        if (userFound != null) {
            return "escolha outro nome.";
        }
        
        // Criptografa a senha antes de salvar
        uso.setPassword(passwordEncoder.encode(uso.getPassword()));
        
        // O id será gerado pelo MongoDB se deixarmos null ou vazio
        uso.setId(null); 
        Usuario saved = usuarioService.criaUsuario(uso);
        DadosService.CriaDadosUse(saved.getId());
        return "ok";
    }

    public String getDadosPorToken(String token) {
        System.out.println("Buscando dados para o token: " + token);
        String username = tokenService.validateToken(token);
        if (username != null) {
            Usuario user = usuarioService.buscarPorNome(username);
            if (user != null) {
                Cabesario cabesario = new Cabesario(token);
                cabesario.setConteudo(DadosService.getDados(user.getId()));
                cabesario.setEstatus("1");
                System.out.println("Dados encontrados para: " + username);
                return new Gson().toJson(cabesario);
            }
        }
        System.out.println("Token inválido ou usuário não encontrado");
        return "0";
    }

    public boolean AtualizaDados(String text) {
        Gson gson = new Gson();
        Cabesario dadosT = gson.fromJson(text, Cabesario.class);
        DadosService.atualizaDados(dadosT.getConteudo());
        return true;
    }

    public String salva(String json) {
        Gson gson = new Gson();
        // Remove quotes if the string was double-stringified (for backward compatibility if frontend isn't fixed yet)
        if (json.startsWith("\"") && json.endsWith("\"")) {
            json = json.substring(1, json.length() - 1).replace("\\\"", "\"").replace("\\\\", "\\");
        }
        
        Cabesario dadosT = gson.fromJson(json, Cabesario.class);

        if (dadosT != null && dadosT.getCredenciais() != null) {
            String username = tokenService.validateToken(dadosT.getCredenciais());
            if (username != null) {
                DadosService.atualizaDados(dadosT.getConteudo());
                return "1";
            }
        }
        return "0";
    }
}
