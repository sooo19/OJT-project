package com.example.server.domain.controller;

import com.example.server.domain.controller.dto.UpdatePostDto;
import com.example.server.domain.model.Post;
import com.example.server.domain.service.PostService;
import com.example.server.domain.service.dto.InternUpdatePostDto;
import com.example.server.domain.service.dto.MemberWithBuddyInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final Long internId = 1L;
    private final Long buddyId = 2L;

    @GetMapping
    public List<Post> posts(){
        return postService.getPosts(internId);
    }

    @GetMapping("/{postId}")
    public Post post(@PathVariable Long postId){
        return postService.getPost(postId);
    }

    @PutMapping("/intern/{postId}")
    public Post updatePostContent(@PathVariable Long postId, UpdatePostDto updatePostDto){
        InternUpdatePostDto internUpdatePostDto = new InternUpdatePostDto(updatePostDto.content(), updatePostDto.report());
        return postService.internUpdatePost(postId, internUpdatePostDto);
    }
    @PutMapping("/buddy/{postId}")
    public Post updatePostFeedback(@PathVariable Long postId, String feedback){
        return postService.buddyUpdatePost(postId, feedback);
    }

    @PutMapping("/post/{postId}/submit/{week}")
    public Post submitPost(@PathVariable Long postId, @PathVariable int week){
        return postService.submitPost(postId, buddyId, week);
    }

    @PutMapping("/post/{postId}/feedback/{week}")
    public Post completePostFeedback(@PathVariable Long postId, @PathVariable int week){
        return postService.buddyCompleteFeedback(postId, internId, week);
    }
}
