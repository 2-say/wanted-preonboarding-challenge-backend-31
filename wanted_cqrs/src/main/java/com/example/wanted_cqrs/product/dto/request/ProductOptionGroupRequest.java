package com.example.wanted_cqrs.product.dto.request;

import java.util.List;

public record ProductOptionGroupRequest(
	String name,
	Integer displayOrder,
	List<ProductOptionRequest> options
) {
}
