package com.vitu.code.repository;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.vitu.code.model.Role;


public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
