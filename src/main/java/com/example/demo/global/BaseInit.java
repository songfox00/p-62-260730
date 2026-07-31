package com.example.demo.global;

import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class BaseInit {

    @Autowired
    private PostRepository postRepository;

    @Bean
    public ApplicationRunner init(){
        return args -> {
            System.out.println("초기화 작업을 수행합니다");
            if(postRepository.count()>0){
                return;
            };

            //post 하나 저장
            Post post = new Post();
            post.setTitle("제목1");
            post.setBody("내용1");
            postRepository.save(post);

            //post 조회
            Optional<Post> opPost= postRepository.findById(1);

            if(opPost.isPresent()){
                System.out.println(opPost.get().getTitle());
                System.out.println(opPost.get().getBody());
            }
        };
    }
}
