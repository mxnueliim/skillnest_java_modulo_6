package com.skillnest.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.skillnest.web.model.Contacto;

@Configuration
public class ContactoConfig {

    // Un bean "prototype" crea una instancia nueva cada vez que se solicita
    @Bean
    @Scope("prototype")
    public Contacto contacto() {
        return new Contacto();
    }
}
