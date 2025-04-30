package com.example.wanted_cqrs.util;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class JsonToMapConverter implements AttributeConverter<Map<String, Object>, String> {
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Map<String, Object> attribute) {
		try {
			return attribute == null ? null : objectMapper.writeValueAsString(attribute);
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException("Map to JSON 실패", e);
		}
	}

	@Override
	public Map<String, Object> convertToEntityAttribute(String dbData) {
		try {
			return dbData == null ? null : objectMapper.readValue(dbData, new TypeReference<>() {});
		} catch (Exception e) {
			throw new IllegalArgumentException("JSON to Map 실패", e);
		}
	}
}