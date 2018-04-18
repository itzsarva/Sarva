package com.sarva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sarva.*")
public class InfiniteApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(InfiniteApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
