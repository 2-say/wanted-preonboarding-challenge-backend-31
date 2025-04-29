package com.example.wanted_cqrs.product.dto.request;

import java.util.List;

import com.example.wanted_cqrs.brand.entity.Brand;
import com.example.wanted_cqrs.product.entity.Product;
import com.example.wanted_cqrs.seller.entity.Seller;

public record CreateProduct(
	String name,
	String slug,
	String shortDescription,
	String fullDescription,
	Long sellerId,
	Long brandId,
	String status,
	ProductDetailRequest detail,
	ProductPriceRequest price,
	List<ProductCategoryRequest> categories,
	List<ProductOptionGroupRequest> optionGroups,
	List<ProductImageRequest> images,
	List<Long> tags
) {
	public Product toEntity(Seller seller, Brand brand) {
		Product product = new Product();
		product.setName(this.name);
		product.setSlug(this.slug);
		product.setShortDescription(this.shortDescription);
		product.setFullDescription(this.fullDescription);
		product.setSeller(seller);
		product.setBrand(brand);
		product.setStatus(this.status);
		return product;
	}
}
