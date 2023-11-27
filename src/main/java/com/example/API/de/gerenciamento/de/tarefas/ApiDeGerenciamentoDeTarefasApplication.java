package com.example.API.de.gerenciamento.de.tarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.API.de.gerenciamento.de.tarefas.Repository")
@EntityScan(basePackages = "com.example.API.de.gerenciamento.de.tarefas.Model")
public class ApiDeGerenciamentoDeTarefasApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiDeGerenciamentoDeTarefasApplication.class, args);
    }
}