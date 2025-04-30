package com.example.wanted_cqrs.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wanted_cqrs.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
