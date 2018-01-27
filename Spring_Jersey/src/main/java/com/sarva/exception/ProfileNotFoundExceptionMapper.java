package com.sarva.exception;

import javax.annotation.Priority;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(2)
public class ProfileNotFoundExceptionMapper implements ExceptionMapper<ProfileNotFoundException> {

	@Override
	public Response toResponse(ProfileNotFoundException exception) {
		ErrorContent content = new ErrorContent(404, exception.getMessage(), "itz_sarva");
		return Response.status(Status.NOT_FOUND).entity(content).build();
	}

}
