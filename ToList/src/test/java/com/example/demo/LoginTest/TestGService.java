package com.example.demo.LoginTest;

import com.example.demo.dbAll.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.Login.GService;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class TestGService {
    private final GService GService;

    @Autowired
    TestGService(GService GService){
        this.GService = GService;
    }

        @Test
        public void TCadstro() {
            String v = "";
            try {
                Usuario use = new Usuario("juzer", "test");
                v = GService.cadastraUsuario(use);
                System.out.println(v);
                if (v == "escolha outro nome.") {
                    assertEquals("escolha outro nome.",v );
                } else {
                    assertEquals("ok", v);
                }
            } catch (Exception x) {
                System.out.println(x);
                System.out.println(v);


            }
        }
        @Test
        public void TvalidadoDeUsuarios() {
            try {
                String usex = "[{\"name\":\"juzer\",\"password\":\"test\"}]";
                String v = GService.validado(usex);
                System.out.println(v);
                assertEquals(true, (v.length() > 4 || v.equals("0")));
            } catch (Exception e) {
                System.out.println(e);
            }
        }




}
