package com.example.blog.service;

import java.util.List;

import com.example.blog.entities.Category;
import com.example.blog.entities.Post;
import com.example.blog.entities.User;
import com.example.blog.payloads.PostDto;

public interface PostService {

	// create post

	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	// update post

	PostDto UpdatePost(PostDto postDto, Integer postId);

	// Delete post

	void DeletePost(Integer postId);

	// Get All Post

	List<PostDto> GetAllPosts();

	// get post By Id

	PostDto GetPostById(Integer postId);

	// get posts by User

	List<PostDto> GetPostByUSer(Integer userId);

	// Get posts by Category

	List<PostDto> GetPostByCategory(Integer categoryId);

	// searching post

	List<Post> SearchPosts(String keyword);

	/////////

}
