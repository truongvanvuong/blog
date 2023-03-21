package com.example.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Blog;

public interface BlogRepostiory extends JpaRepository<Blog, Long>{
}
