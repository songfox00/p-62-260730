package com.example.demo.domain.post.service;

import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post write(String title, String body){
        Post post1=new Post(title, body);
        return postRepository.save(post1);
    }

    public Optional<Post> findById(int id){
        return postRepository.findById(id);
    }

    public long count() {
        return postRepository.count();
    }
}
