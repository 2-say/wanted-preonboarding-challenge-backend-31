package com.example.wanted_cqrs.seller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wanted_cqrs.seller.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
