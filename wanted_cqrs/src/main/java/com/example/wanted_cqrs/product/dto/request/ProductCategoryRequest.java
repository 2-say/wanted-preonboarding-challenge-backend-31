package com.example.wanted_cqrs.product.dto.request;

public record ProductCategoryRequest(
	Long categoryId,
	Boolean isPrimary
) {
}
