package com.sarva.jersey;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.sarva.paramConverters.Details;

@Provider
public class DetailsParamConverter implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		// System.err.println("coming inside converter");
		// System.err.println(rawType.getName());
		// System.err.println(Details.class.getName());
		if (rawType.getName().equals(Details.class.getName())) {
			return new ParamConverter<T>() {
				@SuppressWarnings("unchecked")
				@Override
				public T fromString(String value) {
					Details details = new Details();
					String[] values = value.split("1");
					details.setName(values[0]);
					details.setAge(values[1]);
					return (T) details;
				}

				@Override
				public String toString(T value) {
					return value.toString();
				}
			};
		}
		// System.err.println("returning null");
		return null;
	}

}
