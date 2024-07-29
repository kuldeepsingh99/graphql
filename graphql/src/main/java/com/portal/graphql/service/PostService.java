package com.portal.graphql.service;

import com.portal.graphql.dto.PostDTO;
import com.portal.graphql.entity.PostComments;
import com.portal.graphql.entity.Posts;
import com.portal.graphql.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Posts> findAll(){
        return postRepository.findAll();
    }

    public Posts findById(Long postId){
        return postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not Found"));
    }

    public Posts updatePost(Long postId, String content){
        Posts posts = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not Found"));
        posts.setContent(content);
        return postRepository.save(posts);
    }

    public Posts createPost(String name, String content, Integer noOfLikes, Boolean isDisplay) {
        Posts posts = new Posts(name,
                content,
                noOfLikes,
                isDisplay);
        return postRepository.save(posts);
    }

    public List<PostComments> getCommentsForPost(Long postId) {
        return postRepository.findById(postId)
                .map(Posts::getComments)
                .orElse(Collections.emptyList());
    }

}
