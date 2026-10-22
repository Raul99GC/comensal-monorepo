package com.comensal.organizacion;

import org.springframework.boot.SpringApplication;

public class TestOrganizacionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrganizacionServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
