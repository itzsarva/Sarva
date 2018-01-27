package com.sarva.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.web.bind.annotation.RestController;

@Path("/jer")
@RestController
public class JerseyTest {

	@GET
	@Path("/get")
	@Produces({ "application/json" })
	public RestDTO getString() {
		System.err.println("coming inside get Method");
		RestDTO to = new RestDTO();
		to.setId(10);
		to.setName("YUSSSS!!!!");
		return to;
	}

}
