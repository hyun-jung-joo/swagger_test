package com.example.swaggerPractice1.controller;

import java.net.URI;
import java.util.List;

import com.example.swaggerPractice1.dto.PostRequest;
import com.example.swaggerPractice1.dto.PostResponse;
import com.example.swaggerPractice1.service.PostService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/posts")
@RestController
public class PostController {
    private PostService postService;

    public PostController(final PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostResponse> save(@RequestBody final PostRequest postRequest) {
        final PostResponse postResponse = postService.save(postRequest);
        return ResponseEntity.created(URI.create("/posts/" + postResponse.getId()))
                .body(postResponse);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> findById(@PathVariable final Long postId) {
        return ResponseEntity.ok(postService.findById(postId));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Void> update(@PathVariable final Long postId, @RequestBody final PostRequest postRequest) {
        postService.update(postId, postRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> delete(@PathVariable final Long postId) {
        postService.delete(postId);
        return ResponseEntity.noContent().build();
    }
}