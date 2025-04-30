package com.example.wanted_cqrs.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.wanted_cqrs.product.entity.Product;
import com.example.wanted_cqrs.product.entity.ProductTag;
import com.example.wanted_cqrs.product.repository.ProductTagRepository;
import com.example.wanted_cqrs.tag.entity.Tag;
import com.example.wanted_cqrs.tag.repository.TagRepository;

@Service
public class ProductTagService {
	private final ProductTagRepository productTagRepository;
	private final TagRepository tagRepository;

	public ProductTagService(ProductTagRepository productTagRepository, TagRepository tagRepository) {
		this.productTagRepository = productTagRepository;
		this.tagRepository = tagRepository;
	}

	public void saveProductTag(List<Long> tags, Product product) {
		// 상품 태그 저장
		for (Long t : tags) {
			Tag tag = tagRepository.findById(t).orElseThrow(IllegalStateException::new);

			ProductTag pt = ProductTag.builder()
				.tag(tag)
				.product(product)
				.build();

			productTagRepository.save(pt);
		}
	}
}
