package com.skillnest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BibliotecaAppApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(BibliotecaAppApplication.class, args);
  }

  // Necesario para empaquetar como WAR y desplegar en Tomcat externo
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(BibliotecaAppApplication.class);
  }
}
