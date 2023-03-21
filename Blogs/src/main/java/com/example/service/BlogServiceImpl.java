package com.example.service;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repostiory.BlogRepostiory;
import com.example.model.Blog;


@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepostiory blogRepostiory;

	@Override
	public Blog addBlog(Blog blog) {
		return this.blogRepostiory.save(blog);
	}

	@Override
	public Blog updateBlog(Blog blog) {
		return this.blogRepostiory.save(blog);
	}

	@Override
	public Set<Blog> getBlogs() {
		return new LinkedHashSet<>(this.blogRepostiory.findAll());
	}

	@Override
	public Blog getBlog(Long blogId) {
		return this.blogRepostiory.findById(blogId).get();
	}

	@Override
	public void deleteBlog(Long blogId) {
		this.blogRepostiory.deleteById(blogId);
	}

	@Override
	public Set<Blog> searchBlog(String keyword) {
		Set<Blog> allBlog = getBlogs();
		Set<Blog> result = allBlog.stream()
				.filter(blog -> blog.getTitle().toLowerCase().contains(keyword.toLowerCase()))
				.collect(Collectors.toSet());
		return result;
	}

}
