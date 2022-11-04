package com.vitu.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitu.code.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
