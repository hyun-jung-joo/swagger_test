package com.example.swaggerPractice1.dto;

import com.example.swaggerPractice1.domain.Post;

import javax.validation.constraints.NotNull;

public class PostRequest {

    private String title;
    private String content;

    protected PostRequest() {}

    public Post toEntity() {
        return new Post(this.title, this.content);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
