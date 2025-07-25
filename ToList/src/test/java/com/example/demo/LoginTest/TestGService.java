package com.example.demo.LoginTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.Login.GService;
import com.example.demo.Login.Usuario;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class TestGService {
    private final GService GService;

    @Autowired
    TestGService(GService GService){
        this.GService = GService;
    }

    @Test
    public void testGS(){
        String usex = "[{\"name\":\"juzer\",\"password\":\"test\"}]";
        Usuario use = new Usuario("juzer","test");

        try {
            String v = GService.cadastraUsuario(use);
            System.out.println(v);
        }catch (Exception x){
            System.out.println(x);
        }

        try{
            boolean v = GService.validado(usex);
            System.out.println(v);
            assertEquals(true, v);
        }catch (Exception e){
            System.out.println(e);
        }



    }
}
