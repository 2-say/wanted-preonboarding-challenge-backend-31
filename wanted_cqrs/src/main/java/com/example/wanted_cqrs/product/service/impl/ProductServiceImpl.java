package com.example.wanted_cqrs.product.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	private final ProductCategoryService productCategoryService;
	private final ProductTagService productTagService;
	private final ProductPriceService productPriceService;
	private final ProductDetailService productDetailService;
	private final ProductOptionService productOptionService;
	private final ProductImageService productImageService;

	public ProductServiceImpl(SellerRepository sellerRepository, BrandRepository brandRepository,
		ProductRepository productRepository, ProductCategoryService productCategoryService,
		ProductTagService productTagService, ProductPriceService productPriceService,
		ProductDetailService productDetailService, ProductOptionService productOptionService,
		ProductImageService productImageService) {
		this.sellerRepository = sellerRepository;
		this.brandRepository = brandRepository;
		this.productRepository = productRepository;
		this.productCategoryService = productCategoryService;
		this.productTagService = productTagService;
		this.productPriceService = productPriceService;
		this.productDetailService = productDetailService;
		this.productOptionService = productOptionService;
		this.productImageService = productImageService;
	}

	@Transactional
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

		// 상품 카테고리 저장
		productCategoryService.saveProductCategory(createProduct.categories(), product);

		//상품 태그 저장
		productTagService.saveProductTag(createProduct.tags(), product);

		// 상품 가격 저장
		productPriceService.saveProductPrice(product, createProduct.price());

		// 상품 상세 저장
		productDetailService.saveProductDetail(product, createProduct.detail());

		// 상품 옵션 그룹 저장
		productOptionService.saveProductOption(product, createProduct.optionGroups());

		// 상품 이미지 저장
		productImageService.saveProductImage(product, createProduct.images());
	}
}
