package com.example.wanted_cqrs.product.service.impl;

import org.springframework.stereotype.Service;

import com.example.wanted_cqrs.product.dto.request.ProductDetailRequest;
import com.example.wanted_cqrs.product.entity.Product;
import com.example.wanted_cqrs.product.entity.ProductDetail;
import com.example.wanted_cqrs.product.repository.ProductDetailRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductDetailService {
	private final ProductDetailRepository productDetailRepository;

	public ProductDetailService(ProductDetailRepository productDetailRepository) {
		this.productDetailRepository = productDetailRepository;
	}

	public void saveProductDetail(Product product, ProductDetailRequest detail){
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonDimensions;
		try {
			jsonDimensions = objectMapper.writeValueAsString(detail.dimensions());
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}

		ProductDetail productDetail = ProductDetail.builder()
			.additionalInfo(detail.additionalInfo())
			.careInstructions(detail.careInstructions())
			.materials(detail.materials())
			.countryOfOrigin(detail.countryOfOrigin())
			.warrantyInfo(detail.warrantyInfo())
			.dimensions(jsonDimensions)
			.product(product)
			.build();

		productDetailRepository.save(productDetail);
	}
}
