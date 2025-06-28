package com.backend.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
