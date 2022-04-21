package com.example.blog.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.entities.Category;
import com.example.blog.entities.Post;
import com.example.blog.entities.User;
import com.example.blog.exception.ResourceNotFoundException;
import com.example.blog.payloads.PostDto;
import com.example.blog.payloads.UserDto;
import com.example.blog.repository.CategoryRepo;
import com.example.blog.repository.PostRepo;
import com.example.blog.repository.UserRepo;
import com.example.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId));

		Post posts = this.modelMapper.map(postDto, Post.class);

		posts.setImageName("default.png");
		posts.setAddedDate(new Date());
		posts.setCategory(category);
		posts.setUser(user);

		Post newPost = this.postRepo.save(posts);

		return this.modelMapper.map(newPost, PostDto.class);
	}

	// Update

	@Override
	public PostDto UpdatePost(PostDto postDto, Integer postId) {

		Post posts = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post", "postId", postId));

		posts.setTitle(postDto.getTitle());
		posts.setContent(postDto.getContent());

		Post updatedpost = this.postRepo.save(posts);
		PostDto UpdatedPostDto = this.PostToPostDto(updatedpost);

		return UpdatedPostDto;
	}

	// delete

	@Override
	public void DeletePost(Integer postId) {

		this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "postId", postId));
		this.postRepo.deleteById(postId);

	}

	@Override
	public List<PostDto> GetAllPosts() {

		List<Post> Allposts = this.postRepo.findAll();
		List<PostDto> postsDts = Allposts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postsDts;
	}

//get post by Id
	@Override
	public PostDto GetPostById(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("post", "postId", postId));

		return this.modelMapper.map(post, PostDto.class);
	}

	/**
	 * @Override public List<PostDto> GetPostByUSer(Integer userId) { User
	 *           user=this.userRepo.findById(userId).orElseThrow(()->new
	 *           ResourceNotFoundException("user","usrerId",userId));
	 * 
	 *           List<Post> posts=this.postRepo.FindByUser(user);
	 * 
	 *           List<PostDto>
	 *           postdtos=posts.stream().map((post)->this.modelMapper.map(post,
	 *           PostDto.class)).collect(Collectors.toList());
	 * 
	 * 
	 *           return postdtos; }
	 * 
	 * @Override public List<PostDto> GetPostByCategory(Integer categoryId) {
	 * 
	 * 
	 *           Category
	 *           cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new
	 *           ResourceNotFoundException("Category","category id",categoryId));
	 * 
	 *           List<Post> posts=this.postRepo.FindByCategory(cat); List<PostDto>
	 *           postDtos=posts.stream().map((post)->this.modelMapper.map(post,
	 *           PostDto.class)).collect(Collectors.toList()); return postDtos; }
	 */

	@Override
	public List<Post> SearchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> GetPostByUSer(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> GetPostByCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

//for converting postDTO TO posT'''''''''''''''''''''''''''''''
	public Post DtoToPost(PostDto postDto) {

		Post post = this.modelMapper.map(postDto, Post.class);

		return post;

	}

//for post to postDto

	public PostDto PostToPostDto(Post post) {

		PostDto postDto = this.modelMapper.map(post, PostDto.class);

		return postDto;

	}

}
