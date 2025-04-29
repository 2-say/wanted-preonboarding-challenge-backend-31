package com.example.wanted_cqrs.product.dto.request;

import java.math.BigDecimal;
import java.util.Map;

public record ProductDetailRequest(
	BigDecimal weight,
	Dimensions dimensions,
	String materials,
	String countryOfOrigin,
	String warrantyInfo,
	String careInstructions,
	Map<String, Object> additionalInfo
) {
}
