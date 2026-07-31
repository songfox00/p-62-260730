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
            System.out.println("초기화 작업을 수행합니다");
            work1();
            work2();
        };
    }

    void work1() {

        if(postRepository.count() > 0) {
            return;
        }

        Post post1 = new Post("제목1", "내용1");
        postRepository.save(post1);

        Post post2 = new Post("제목2", "내용2");
        postRepository.save(post2);
    }

    void work2() {
        postRepository.findById(1);
        // select * from post where id = 1;
    }
}
