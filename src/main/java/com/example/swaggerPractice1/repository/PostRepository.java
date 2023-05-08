package com.example.swaggerPractice1.repository;

import com.example.swaggerPractice1.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
