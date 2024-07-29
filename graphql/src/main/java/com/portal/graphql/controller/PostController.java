package com.portal.graphql.controller;

import com.portal.graphql.dto.PostDTO;
import com.portal.graphql.entity.PostComments;
import com.portal.graphql.entity.Posts;
import com.portal.graphql.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public List<Posts> getAllPosts(){
        return postService.findAll();
    }

    @QueryMapping
    public Posts getPostById(@Argument String postId){
        return postService.findById(Long.valueOf(postId));
    }

    @MutationMapping
    public Posts createNewPost(@Argument PostDTO postDTO){
        return postService.createPost(postDTO.getName(),postDTO.getContent(),
                postDTO.getNoOfLikes(),postDTO.isDisplay());
    }


}
