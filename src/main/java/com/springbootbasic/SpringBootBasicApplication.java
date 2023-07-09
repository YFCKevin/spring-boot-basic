package com.springbootbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicApplication.class, args);
	}

}
