package com.example.hlhwsaver.repo;

import com.example.hlhwsaver.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

}
