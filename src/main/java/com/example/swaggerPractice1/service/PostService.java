package com.example.swaggerPractice1.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.swaggerPractice1.domain.Post;
import com.example.swaggerPractice1.dto.PostRequest;
import com.example.swaggerPractice1.dto.PostResponse;
import com.example.swaggerPractice1.repository.PostRepository;

import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponse save(final PostRequest postRequest) {
        final Post post = postRepository.save(postRequest.toEntity());
        return PostResponse.of(post);
    }
    public List<PostResponse> findAll() {
        final List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(PostResponse::of)
                .collect(Collectors.toList());
    }

    public PostResponse findById(final Long postId) {
        final Post post = postRepository.findById(postId)
                .orElseThrow(RuntimeException::new);
        return PostResponse.of(post);
    }

    public void update(final Long postId, final PostRequest postRequest) {
        final Post post = postRepository.findById(postId)
                .orElseThrow(RuntimeException::new);
        post.update(postRequest.toEntity());
    }

    public void delete(final Long postId) {
        final Post post = postRepository.findById(postId)
                .orElseThrow(RuntimeException::new);
        postRepository.delete(post);
    }
}
