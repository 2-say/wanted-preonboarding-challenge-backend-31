package com.example.wanted_cqrs.product.service.impl;

import org.springframework.stereotype.Service;

import com.example.wanted_cqrs.product.dto.request.ProductPriceRequest;
import com.example.wanted_cqrs.product.entity.Product;
import com.example.wanted_cqrs.product.entity.ProductPrice;
import com.example.wanted_cqrs.product.repository.ProductPriceRepository;

@Service
public class ProductPriceService {

	private final ProductPriceRepository productPriceRepository;

	public ProductPriceService(ProductPriceRepository productPriceRepository) {
		this.productPriceRepository = productPriceRepository;
	}

	public void saveProductPrice(Product product, ProductPriceRequest price) {
		ProductPrice productPrice = ProductPrice.builder()
			.basePrice(price.basePrice())
			.salePrice(price.salePrice())
			.costPrice(price.costPrice())
			.currency(price.currency())
			.taxRate(price.taxRate())
			.product(product)
			.build();

		productPriceRepository.save(productPrice);
	}
}
