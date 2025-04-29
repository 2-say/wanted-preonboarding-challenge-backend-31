package com.example.wanted_cqrs.brand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wanted_cqrs.brand.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
