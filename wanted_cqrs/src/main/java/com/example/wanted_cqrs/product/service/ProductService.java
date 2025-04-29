package com.example.wanted_cqrs.product.service;

import com.example.wanted_cqrs.product.dto.request.CreateProduct;

public interface ProductService {
	public void registerProduct(CreateProduct createProduct);
}
