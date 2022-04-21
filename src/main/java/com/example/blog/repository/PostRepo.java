package com.example.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.entities.Category;
import com.example.blog.entities.Post;
import com.example.blog.entities.User;

public interface PostRepo extends JpaRepository<Post,Integer>{
	
//	List<Post> FindByUser(User user);
	
	//List<Post> FindByCategory(Category category);
	

}
