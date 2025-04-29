package com.example.wanted_cqrs.product.dto.request;

import java.math.BigDecimal;

public record ProductPriceRequest(
	BigDecimal basePrice,
	BigDecimal salePrice,
	BigDecimal costPrice,
	String currency,
	BigDecimal taxRate
) {
}
