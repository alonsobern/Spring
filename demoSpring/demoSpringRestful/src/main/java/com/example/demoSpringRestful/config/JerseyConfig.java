package com.example.demoSpringRestful.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;


//Estructura básica para crear y hacer el llamado a controladores, debo especificar que es un componente y Path
@ApplicationPath("/") //Le indico que la aplicación se ejecuta luego del '/'
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        this.packages("com.example.demoSpringRestful.controllers");
    }
}
