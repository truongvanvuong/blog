package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Blog;
import com.example.service.BlogService;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {

	@Autowired
	private BlogService blogService;

	// add blog
	@PostMapping("/")
	public ResponseEntity<?> addBlog(@RequestBody Blog blog) {
		Blog blog1 = this.blogService.addBlog(blog);
		return ResponseEntity.ok(blog1);
	}

	// get blog
	@GetMapping("/{blogId}")
	public Blog getBlog(@PathVariable("blogId") Long blogId) {
		return this.blogService.getBlog(blogId);
	}

	// get all 
	@GetMapping("/")
	public ResponseEntity<?> getBlogs() {
		return ResponseEntity.ok(this.blogService.getBlogs());
	}
	//update 
	@PutMapping("/")
	public Blog updateBlog(@RequestBody Blog blog) {
		return this.blogService.updateBlog(blog);
	}
	
	@DeleteMapping("/{blogId}")
	public void deleteBlog(@PathVariable("blogId") Long blogId) {
		 this.blogService.deleteBlog(blogId);
	}
	@GetMapping("/search/{keyvalue}")
	public ResponseEntity<?> searchBlog(@PathVariable("keyvalue") String keyvalue) {
	    return ResponseEntity.ok(this.blogService.searchBlog(keyvalue));
	}
}
