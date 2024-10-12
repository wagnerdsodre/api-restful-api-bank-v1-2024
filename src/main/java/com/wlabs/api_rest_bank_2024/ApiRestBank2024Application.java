package com.wlabs.api_rest_bank_2024;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(servers = { @Server(url="/", description = "Default server url") })
@SpringBootApplication
public class ApiRestBank2024Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestBank2024Application.class, args);
	}

}
