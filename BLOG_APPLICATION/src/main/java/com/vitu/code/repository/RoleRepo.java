package com.vitu.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitu.code.model.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
