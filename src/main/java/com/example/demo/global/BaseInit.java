package com.example.demo.global;

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
        };
    }
}
