package com.sarva.custom;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sarva.entity.Shares;

public class JsonDeserialization3 extends JsonDeserializer<List<Shares>> {

	@Override
	public List<Shares> deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		InnerItems innerItems = jp.readValueAs(InnerItems.class);

		return innerItems.elements;
	}

	private static class InnerItems {
		public List<Shares> elements;
	}

}
