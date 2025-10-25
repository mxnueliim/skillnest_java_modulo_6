package com.skillnest.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.skillnest.agenda")
public class AgendaCompartidaApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder
                .sources(AgendaCompartidaApplication.class)
                // Deshabilita ErrorMvcAutoConfiguration en WAR (evita doble ErrorPageFilter)
                .properties(
                    "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration",
                    "spring.main.web-application-type=servlet"
                );
    }

    public static void main(String[] args) {
        SpringApplication.run(AgendaCompartidaApplication.class, args);
    }
}
