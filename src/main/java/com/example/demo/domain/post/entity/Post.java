package com.example.demo.domain.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter // 어노테이션. 표식(자바, 프레임워크, IDE)
@Entity
@RequiredArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id;
    private final String title;
    private final String body;

    public Post(){
        title="";
        body="";
    }
}