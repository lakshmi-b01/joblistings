package com.saieeshamongo.joblisting.controller;

import com.saieeshamongo.joblisting.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    private List<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return posts;
    }

    @PostMapping("/posts")
    public String createPost(@RequestBody Post post) {
        posts.add(post);
        return "Post created: " + post;
    }

}
