package com.example.server.domain.repository;

import com.example.server.domain.model.Member;
import com.example.server.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByMember(Member member);

    @Query("SELECT p FROM Post p WHERE p.week = :week")
    Optional<Post> findByWeek(int week);
}