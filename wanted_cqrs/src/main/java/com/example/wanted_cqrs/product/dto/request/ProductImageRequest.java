package com.example.wanted_cqrs.product.dto.request;

public record ProductImageRequest(
	String url,
	String altText,
	Boolean isPrimary,
	Integer displayOrder,
	Long optionId
) {
}
