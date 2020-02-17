package com.spring.app.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.spring.app.ws.*")
@ComponentScan(basePackages = { "com.spring.app.ws.*" })
@EntityScan("com.spring.app.ws.*")   
@SpringBootApplication
public class SpringMobileAppWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMobileAppWsApplication.class, args);
	}

}
