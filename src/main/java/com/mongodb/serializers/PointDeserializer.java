package com.mongodb.serializers;

import java.io.IOException;

import org.springframework.data.geo.Point;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class PointDeserializer extends JsonDeserializer<Point> {

	@Override
	public Point deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectCodec codec = p.getCodec();
		JsonNode node = codec.readTree(p);
		return new Point(node.get(0).asDouble(), node.get(1).asDouble());
	}

}
