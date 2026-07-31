package com.example.demo.domain.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter // 어노테이션. 표식(자바, 프레임워크, IDE)
@Entity
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id;
    private String title;
    private String body;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public Post(String title, String body){
        this.title = title;
        this.body = body;
        createDate=LocalDateTime.now();
        modifyDate=createDate;
    }
}