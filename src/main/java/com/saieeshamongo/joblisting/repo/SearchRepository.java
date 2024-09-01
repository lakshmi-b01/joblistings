package com.saieeshamongo.joblisting.repo;

import com.saieeshamongo.joblisting.model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByIndex(String index);
}
