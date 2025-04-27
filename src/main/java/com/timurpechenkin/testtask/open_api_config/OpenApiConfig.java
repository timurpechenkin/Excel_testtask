package com.timurpechenkin.testtask.open_api_config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI defineOpenApi() {
		Server server = new Server();
		server.setUrl("http://localhost:8080");
		server.setDescription("Development");

		Contact myContact = new Contact();
		myContact.setName("Timur Pechenkin");
		myContact.setEmail("pechenkin.timur@yandex.ru");

		Info information = new Info().title("Excel API").version("1.0").description("This API exposes endpoints to manage XLSX files.").contact(myContact);
		return new OpenAPI().info(information).servers(List.of(server));
	}
}
