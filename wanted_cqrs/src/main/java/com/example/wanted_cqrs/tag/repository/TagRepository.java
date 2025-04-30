package com.example.wanted_cqrs.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wanted_cqrs.tag.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
