package com.greenbite.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Esta es la "magia" que activa la configuración automática de Spring
public class App {

    public static void main(String[] args) {
        // Esta línea es la que realmente inicia todo el ecosistema del backend
        SpringApplication.run(App.class, args);
    }
}