package com.example.demo.domain.post.service;

import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post write(String title, String body){
        Post post=new Post(title, body);

        return postRepository.save(post);  //트랜잭션 시작 -> insert ... -> 트랜잭션 종료 -> 커밋
    }

    public Optional<Post> findById(int id){
        return postRepository.findById(id);
    }

    public long count() {
        return postRepository.count();
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public void modify(Post post, String title, String body) {
        post.setTitle(title);
        post.setBody(body);
        post.setModifyDate(LocalDateTime.now());

        postRepository.save(post);
    }
}
