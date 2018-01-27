package com.sarva.custom;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sarva.entity.Likes;

public class JsonDeserialization2 extends JsonDeserializer<List<Likes>> {

	@Override
	public List<Likes> deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		InnerItems innerItems = jp.readValueAs(InnerItems.class);

		return innerItems.elements;
	}

	private static class InnerItems {
		public List<Likes> elements;
	}

}
