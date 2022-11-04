package com.vitu.code.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.vitu.code.payload.CommentDto;
import com.vitu.code.payload.UserDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private Integer postId;
	
	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;	
	
	private CategoryDto category;

	private UserDto user;
	
	private Set<CommentDto> comments=new HashSet<>();

}