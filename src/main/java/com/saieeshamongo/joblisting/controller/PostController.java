package com.saieeshamongo.joblisting.controller;

import com.saieeshamongo.joblisting.model.Post;
import com.saieeshamongo.joblisting.repo.PostRepository;
import com.saieeshamongo.joblisting.repo.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository searchRepo;

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return searchRepo.findByIndex(text);
    }

    @PostMapping("/posts")
    public String createPost(@RequestBody Post post){
        repo.insert(post);
        return "Post create is: " + post;
    }

}
