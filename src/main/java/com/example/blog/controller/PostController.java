package com.example.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.payloads.ApiResponse;
import com.example.blog.payloads.PostDto;
import com.example.blog.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postservice;

	// create post

	@PostMapping("User/{userId}/Category/{categoryId}/posts")
	public ResponseEntity<PostDto> CreatePost(@RequestBody PostDto postdto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {

		PostDto createdpost = this.postservice.createPost(postdto, userId, categoryId);

		return new ResponseEntity<PostDto>(createdpost, HttpStatus.CREATED);

	}

	// update posts

	@PutMapping("update/{postId}")
	public ResponseEntity<PostDto> UpdatePosts(@RequestBody PostDto postDto, @PathVariable Integer postId) {

		PostDto updatePost = this.postservice.UpdatePost(postDto, postId);

		return ResponseEntity.ok(updatePost);

	}
	// get by user

	@GetMapping("user/{userId}/posts")
	public ResponseEntity<List<PostDto>> GetPostsByUser(@PathVariable Integer userId) {

		// List<PostDto> posts=this.postservice.GetPostByUSer(userId);

		return new ResponseEntity<List<PostDto>>(this.postservice.GetPostByUSer(userId), HttpStatus.OK);

	}

	// get by category

	@GetMapping("category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> GetPostsByCategory(@PathVariable Integer categoryId) {

		// List<PostDto> posts=this.postservice.GetPostByUSer(userId);

		return new ResponseEntity<List<PostDto>>(this.postservice.GetPostByCategory(categoryId), HttpStatus.OK);

	}

	// get All posts
	@GetMapping("all/posts")
	public ResponseEntity<List<PostDto>> GetAllposts() {
		List<PostDto> getAllPosts = this.postservice.GetAllPosts();

		return new ResponseEntity<List<PostDto>>(getAllPosts, HttpStatus.OK);

	}

	// get by post by Id

	@PostMapping("/posts/{postId}")
	public ResponseEntity<PostDto> GetPostById(@PathVariable Integer postId) {

		PostDto getPostById = this.postservice.GetPostById(postId);

		return new ResponseEntity<PostDto>(getPostById, HttpStatus.OK);

	}

	// delete posts by id

	@DeleteMapping("delete/{postId}")
	public ResponseEntity<ApiResponse> DeletePost(@PathVariable Integer postId) {

		this.postservice.DeletePost(postId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("post is deleted successfully!!", true), HttpStatus.OK);
	}
}
