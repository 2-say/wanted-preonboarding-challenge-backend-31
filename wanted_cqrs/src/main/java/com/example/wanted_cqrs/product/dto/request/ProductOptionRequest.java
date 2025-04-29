package com.example.wanted_cqrs.product.dto.request;

import java.math.BigDecimal;

public record ProductOptionRequest(
	String name,
	BigDecimal additionalPrice,
	String sku,
	Integer stock,
	Integer displayOrder
) {
}
