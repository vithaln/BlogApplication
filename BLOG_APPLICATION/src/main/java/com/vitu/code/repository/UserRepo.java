package com.vitu.code.repository;

import java.util.Optional;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vitu.code.model.User;

@Lazy
public interface UserRepo extends JpaRepository<User, Integer>{
		

	Optional<User> findByEmail(String email);
}

