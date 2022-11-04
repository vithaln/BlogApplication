package com.vitu.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitu.code.model.Comment;

public interface CommentRepo  extends JpaRepository<Comment	, Integer> {

}
