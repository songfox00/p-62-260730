package com.example.demo.global;

import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInit {

    @Autowired
    private PostRepository postRepository;

    @Bean
    public ApplicationRunner init(){
        return args -> {
            System.out.println("post의 row 개수를 셉니다.");
            postRepository.count();

            //post 하나 저장
            Post post = new Post();
            post.setTitle("제목1");
            post.setBody("내용1");
            postRepository.save(post);

            //post 조회
        };
    }
}
