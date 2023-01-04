package com.example.server.domain.post.repository;

import com.example.server.domain.member.repository.CustomMemberRepository;
import com.example.server.domain.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, CustomMemberRepository {

}