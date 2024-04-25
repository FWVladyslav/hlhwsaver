package com.example.hlhwsaver.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Entity(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "postId")
public class Post {
    public Post(Integer userId, String content) {
        this.userId = userId;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private Integer userId;
    private String content;
}
