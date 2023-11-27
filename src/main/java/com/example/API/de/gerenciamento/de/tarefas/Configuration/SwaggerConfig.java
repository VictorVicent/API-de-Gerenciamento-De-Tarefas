package com.example.API.de.gerenciamento.de.tarefas.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
   @Bean
   public OpenAPI tasksOpenApi() {
      return new OpenAPI().info(new Info()
         .title("API To-Do List")
         .description("Esta API é utilizada para agendamento de tarefas\n\n" +
         "Contatos:\n\n" +
         "André Luiz F. Martins - andre.martins30@fatec.sp.gov.br\n\n" +
         "Diego Sampaio Gabarrão - diego.gabarrao@fatec.sp.gov.br\n")+
         "Pedro Estevam Blanco Campbell - pedro.campbell@fatec.sp.gov.br\n")+
         "Victor Vicente Alves - victor.alves26@fatec.sp.gov.br\n")
         .version("v0.0.1")
         .license(new License()
           .name("Apache 2.0").url("http://springdoc.org")));
   }
}