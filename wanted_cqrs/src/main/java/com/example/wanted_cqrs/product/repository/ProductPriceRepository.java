package com.example.wanted_cqrs.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wanted_cqrs.product.entity.ProductPrice;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
}
