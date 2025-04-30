package com.example.wanted_cqrs.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wanted_cqrs.product.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
