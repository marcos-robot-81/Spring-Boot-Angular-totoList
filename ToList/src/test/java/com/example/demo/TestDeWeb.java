package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDeWeb {

    @Test
    void LoginTest() throws Exception{
        String json = """
                {
                "nome":"Marcos",
                "senha":"33"
                }
                """;


    }
}
