package com.example.wanted_cqrs.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.wanted_cqrs.category.entity.Category;
import com.example.wanted_cqrs.category.repository.CategoryRepository;
import com.example.wanted_cqrs.product.dto.request.ProductCategoryRequest;
import com.example.wanted_cqrs.product.entity.Product;
import com.example.wanted_cqrs.product.entity.ProductCategory;
import com.example.wanted_cqrs.product.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {

	private final ProductCategoryRepository productCategoryRepository;
	private final CategoryRepository categoryRepository;

	public ProductCategoryService(ProductCategoryRepository productCategoryRepository,
		CategoryRepository categoryRepository) {
		this.productCategoryRepository = productCategoryRepository;
		this.categoryRepository = categoryRepository;
	}

	public void saveProductCategory(List<ProductCategoryRequest> categories, Product product) {
		// 상품 카테고리 저장
		for (ProductCategoryRequest c : categories) {
			Category category = categoryRepository.findById(c.categoryId()).orElseThrow(IllegalStateException::new);

			ProductCategory pc = ProductCategory.builder()
				.category(category)
				.isPrimary(c.isPrimary())
				.product(product)
				.build();

			productCategoryRepository.save(pc);
		}
	}
}
