package com.saieeshamongo.joblisting.repo;

import com.saieeshamongo.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
