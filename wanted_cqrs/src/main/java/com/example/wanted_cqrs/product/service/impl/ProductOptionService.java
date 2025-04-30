package com.example.wanted_cqrs.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.wanted_cqrs.product.dto.request.ProductImageRequest;
import com.example.wanted_cqrs.product.dto.request.ProductOptionGroupRequest;
import com.example.wanted_cqrs.product.dto.request.ProductOptionRequest;
import com.example.wanted_cqrs.product.entity.Product;
import com.example.wanted_cqrs.product.entity.ProductOption;
import com.example.wanted_cqrs.product.entity.ProductOptionGroup;
import com.example.wanted_cqrs.product.repository.ProductOptionGroupRepository;
import com.example.wanted_cqrs.product.repository.ProductOptionRepository;

@Service
public class ProductOptionService {

	private final ProductOptionGroupRepository productOptionGroupRepository;
	private final ProductOptionRepository productOptionRepository;

	public ProductOptionService(ProductOptionGroupRepository productOptionGroupRepository,
		ProductOptionRepository productOptionRepository) {
		this.productOptionGroupRepository = productOptionGroupRepository;
		this.productOptionRepository = productOptionRepository;
	}

	public void saveProductOption(Product product, List<ProductOptionGroupRequest> pgr) {
		for (ProductOptionGroupRequest p : pgr) {
			ProductOptionGroup productOptionGroup = ProductOptionGroup.builder()
				.name(p.name())
				.displayOrder(p.displayOrder())
				.product(product)
				.build();

			productOptionGroupRepository.save(productOptionGroup);

			List<ProductOptionRequest> options = p.options();
			for(ProductOptionRequest por : options) {
				ProductOption po = ProductOption.builder()
					.optionGroup(productOptionGroup)
					.name(por.name())
					.additionalPrice(por.additionalPrice())
					.sku(por.sku())
					.stock(por.stock())
					.displayOrder(por.displayOrder())
					.build();

				productOptionRepository.save(po);
			}
		}
	}
}
