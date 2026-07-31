package com.example.demo.global;

import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class BaseInit {

    private final PostService postService;
    @Lazy
    @Autowired
    private BaseInit self;

    @Bean
    public ApplicationRunner init(){
        return args -> {
            System.out.println("초기화 작업을 수행합니다");

            work1();
            work2();

//            new Thread(()->{
//                self.work3();
//            }).start();

            work4();
        };
    }

    @Transactional
    void work1() {

        if(postService.count() > 0) {
            return;
        }

        postService.write("제목1", "내용1");
        postService.write("제목2", "내용2");
    }

    @Transactional(readOnly = true)
    void work2() {
        postService.findById(1);
        // select * from post where id = 1;
    }

    @Transactional
    void work3(){
        Post post1 = postService.findById(1).get();
        Post post2 = postService.findById(2).get();

        postService.delete(post1);

        if(true){
            throw new RuntimeException("테스트 예외");
        }

        postService.delete(post2);
    }

    @Transactional
    void work4(){
        Post post1 = postService.findById(1).get();
        postService.modify(post1, "제목1-수정", "내용1-수정");
    }
}
