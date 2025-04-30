package com.example.wanted_cqrs.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.wanted_cqrs.product.dto.request.ProductImageRequest;
import com.example.wanted_cqrs.product.entity.Product;
import com.example.wanted_cqrs.product.entity.ProductImage;
import com.example.wanted_cqrs.product.entity.ProductOption;
import com.example.wanted_cqrs.product.repository.ProductImageRepository;
import com.example.wanted_cqrs.product.repository.ProductOptionRepository;

@Service
public class ProductImageService {

	private final ProductImageRepository productImageRepository;
	private final ProductOptionRepository productOptionRepository;

	public ProductImageService(ProductImageRepository productImageRepository,
		ProductOptionRepository productOptionRepository) {
		this.productImageRepository = productImageRepository;
		this.productOptionRepository = productOptionRepository;
	}

	public void saveProductImage(Product product, List<ProductImageRequest> images) {
		for (ProductImageRequest i : images) {
			ProductOption productOption = null;

			if (i.optionId() != null) {
				productOption = productOptionRepository.findById(i.optionId())
					.orElseThrow(IllegalStateException::new);
			}

			ProductImage pi = ProductImage.builder()
				.product(product)
				.url(i.url())
				.altText(i.altText())
				.isPrimary(i.isPrimary())
				.displayOrder(i.displayOrder())
				.option(productOption)
				.build();

			productImageRepository.save(pi);
		}
	}
}
