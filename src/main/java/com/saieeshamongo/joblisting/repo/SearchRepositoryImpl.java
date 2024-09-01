package com.saieeshamongo.joblisting.repo;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.saieeshamongo.joblisting.model.Post;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter convertor;
    @Override
    public List<Post> findByIndex(String index){
        List<Post> searchPosts = new ArrayList<>();
        MongoDatabase database = client.getDatabase("saieesha");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", index)
                                        .append("path", Arrays.asList("techs", "profile", "desc")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));
        result.forEach(doc -> searchPosts.add(convertor.read(Post.class, doc)));
        return searchPosts;
    }
}
