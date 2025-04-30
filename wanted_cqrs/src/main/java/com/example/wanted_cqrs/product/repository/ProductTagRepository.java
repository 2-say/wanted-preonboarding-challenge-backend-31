package com.example.wanted_cqrs.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wanted_cqrs.product.entity.ProductTag;
import com.example.wanted_cqrs.tag.entity.Tag;

public interface ProductTagRepository extends JpaRepository<ProductTag, Long> {
}
