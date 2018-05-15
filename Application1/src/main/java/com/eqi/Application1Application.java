package com.eqi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sarva.*")
public class Application1Application {

	public static void main(String[] args) {
		SpringApplication.run(Application1Application.class, args);
	}
}
