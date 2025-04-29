package com.example.wanted_cqrs.product.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wanted_cqrs.product.dto.request.CreateProduct;
import com.example.wanted_cqrs.product.service.ProductService;

@RequestMapping("/api/products")
@RestController
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public String createProduct(@RequestBody CreateProduct createProduct) {
		productService.registerProduct(createProduct);
		System.out.println(createProduct.toString());
		return "테스트";
	}
}
