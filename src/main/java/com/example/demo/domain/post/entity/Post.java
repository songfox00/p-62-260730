package com.example.demo.domain.post.entity;

import com.example.demo.global.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter // 어노테이션. 표식(자바, 프레임워크, IDE)
@Entity
@NoArgsConstructor
public class Post extends BaseEntity {
    private String title;
    private String body;
    
    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public void modify(String title, String body){
        this.title=title;
        this.body=body;
    }
}