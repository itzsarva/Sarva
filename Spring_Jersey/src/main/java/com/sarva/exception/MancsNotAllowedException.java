package com.sarva.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MancsNotAllowedException extends RuntimeException implements ExceptionMapper<MancsNotAllowedException> {

	/**
	 * for serialization
	 */
	private static final long serialVersionUID = 5543497537382579749L;

	public MancsNotAllowedException() {
		super();
	}

	public MancsNotAllowedException(String message) {
		super(message);
	}

	@Override
	public Response toResponse(MancsNotAllowedException exception) {
		ErrorContent content = new ErrorContent(406, exception.getMessage(), "itz_sarva");
		return Response.status(Status.NOT_ACCEPTABLE).entity(content).build();
	}

}
