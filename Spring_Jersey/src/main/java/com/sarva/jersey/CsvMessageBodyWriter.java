package com.sarva.jersey;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.sarva.entity.Profile;

@Produces("application/csv")
@Provider
public class CsvMessageBodyWriter implements MessageBodyWriter<Profile> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return Profile.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(Profile t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public void writeTo(@JsonUnwrapped Profile t, Class<?> type, Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		System.err.println("coming insode csv");
		final CsvMapper mapper = new CsvMapper();
		final CsvSchema schema = mapper.schemaFor(Profile.class);
		final String csv = mapper.writer(schema.withUseHeader(true)).writeValueAsString(t);
		entityStream.write(csv.getBytes());
		entityStream.flush();
	}

}
