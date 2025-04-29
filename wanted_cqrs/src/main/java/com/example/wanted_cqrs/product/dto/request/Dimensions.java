package com.example.wanted_cqrs.product.dto.request;

public record Dimensions(
	Integer width,
	Integer height,
	Integer depth
) {}
