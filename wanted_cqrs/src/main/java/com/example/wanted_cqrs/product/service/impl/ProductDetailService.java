package com.example.wanted_cqrs.product.service.impl;

import org.springframework.stereotype.Service;

import com.example.wanted_cqrs.product.dto.request.ProductDetailRequest;
import com.example.wanted_cqrs.product.entity.Product;
import com.example.wanted_cqrs.product.entity.ProductDetail;
import com.example.wanted_cqrs.product.repository.ProductDetailRepository;

@Service
public class ProductDetailService {
	private final ProductDetailRepository productDetailRepository;

	public ProductDetailService(ProductDetailRepository productDetailRepository) {
		this.productDetailRepository = productDetailRepository;
	}

	public void saveProductDetail(Product product, ProductDetailRequest detail) {
		// TODO jsonb 변환 additional
		// TODO json dimensions

		ProductDetail productDetail = ProductDetail.builder()
			.additionalInfo(detail.additionalInfo().toString())
			.careInstructions(detail.careInstructions())
			.materials(detail.materials())
			.countryOfOrigin(detail.countryOfOrigin())
			.warrantyInfo(detail.warrantyInfo())
			.dimensions(String.valueOf(detail.dimensions()))
			.product(product)
			.build();

		productDetailRepository.save(productDetail);
	}
}
