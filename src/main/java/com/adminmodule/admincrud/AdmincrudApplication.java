package com.adminmodule.admincrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan("model")
@EnableJpaRepositories("dao")
@ComponentScan("controller")
@SpringBootApplication
public class AdmincrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmincrudApplication.class, args);
	}

}






