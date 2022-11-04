package com.vitu.code.repository;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vitu.code.model.Category;
@Lazy
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
