package com.example.wanted_cqrs.product.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.wanted_cqrs.brand.entity.Brand;
import com.example.wanted_cqrs.brand.repository.BrandRepository;
import com.example.wanted_cqrs.product.dto.request.CreateProduct;
import com.example.wanted_cqrs.product.entity.Product;
import com.example.wanted_cqrs.product.repository.ProductRepository;
import com.example.wanted_cqrs.product.service.ProductService;
import com.example.wanted_cqrs.seller.entity.Seller;
import com.example.wanted_cqrs.seller.repository.SellerRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private final SellerRepository sellerRepository;
	private final BrandRepository brandRepository;
	private final ProductRepository productRepository;

	public ProductServiceImpl(SellerRepository sellerRepository, BrandRepository brandRepository,
		ProductRepository productRepository) {
		this.sellerRepository = sellerRepository;
		this.brandRepository = brandRepository;
		this.productRepository = productRepository;
	}

	@Override
	public void registerProduct(CreateProduct createProduct) {
		// save product entity
		Long sellerId = createProduct.sellerId();
		Seller seller = sellerRepository.findById(sellerId).orElseThrow(IllegalStateException::new);

		Long brandId = createProduct.brandId();
		Brand brand = brandRepository.findById(brandId).orElseThrow(IllegalStateException::new);

		Product product = Product.builder().seller(seller).brand(brand).slug(createProduct.slug())
			.createdAt(LocalDateTime.now())
			.fullDescription(createProduct.fullDescription())
			.shortDescription(createProduct.shortDescription())
			.status(createProduct.status())
			.name(createProduct.name())
			.build();

		productRepository.save(product);

		//



	}
}
