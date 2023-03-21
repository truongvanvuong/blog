package com.example.service;

import java.util.Set;

import com.example.model.Blog;

public interface BlogService {
	public Blog addBlog(Blog blog);
	public Blog updateBlog(Blog blog);
	public Set<Blog> getBlogs();
	public Blog getBlog(Long blogId);
	public void deleteBlog(Long blogId);
	public Set<Blog> searchBlog(String keyword);
}
