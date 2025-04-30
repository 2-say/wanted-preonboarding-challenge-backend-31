package com.example.wanted_cqrs.product.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_prices")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPrice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;

	private BigDecimal basePrice;
	private BigDecimal salePrice;
	private BigDecimal costPrice;
	private String currency = "KRW";
	private BigDecimal taxRate;
}