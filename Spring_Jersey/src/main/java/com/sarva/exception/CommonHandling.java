package com.sarva.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CommonHandling extends Exception implements ExceptionMapper<CommonHandling> {

	/**
	 * for serialization
	 */
	private static final long serialVersionUID = 8743592081843395078L;

	public CommonHandling() {
		super();
	}

	public CommonHandling(String message) {
		super(message);
	}

	@Override
	public Response toResponse(CommonHandling exception) {
		ErrorContent content = new ErrorContent(505, exception.getMessage(), "itz_sarva");
		return Response.status(Status.UNAUTHORIZED).entity(content).build();
	}

}
