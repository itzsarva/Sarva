package com.sarva.jersey;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		System.err.println("coming inside jersey");
		packages("com.sarva.jersey");
		packages("com.sarva.exception");
		packages("com.sarva.paramConverters");
	}
}