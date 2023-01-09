package com.example.server.domain.controller;

import com.example.server.domain.controller.dto.UpdatePostDto;
import com.example.server.domain.model.Post;
import com.example.server.domain.service.PostService;
import com.example.server.domain.service.dto.InternUpdatePostDto;
import com.example.server.domain.service.dto.MemberWithBuddyInfoDto;
import com.example.server.domain.util.OutportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final Long internId = 1L;
    private final Long buddyId = 2L;

    @GetMapping
    public @ResponseBody LinkedHashMap<String, Object> posts(){
        return OutportMapper.toDto(postService.getPosts(internId));
    }

    @GetMapping("/{postId}")
    public @ResponseBody LinkedHashMap<String, Object> post(
            @PathVariable Long postId
    ){
        return OutportMapper.toDto(postService.getPost(postId));
    }

    @PostMapping("/intern/{postId}")
    public @ResponseBody LinkedHashMap<String, Object> updatePostContent(
            @PathVariable Long postId, UpdatePostDto updatePostDto
    ){
        InternUpdatePostDto internUpdatePostDto = new InternUpdatePostDto(updatePostDto.content(), updatePostDto.report());
        return OutportMapper.toDto(postService.internUpdatePost(postId, internUpdatePostDto));
    }
    @PostMapping("/buddy/{postId}")
    public @ResponseBody LinkedHashMap<String, Object> updatePostFeedback(
            @PathVariable Long postId, String feedback
    ){
        return OutportMapper.toDto(postService.buddyUpdatePost(postId, feedback));
    }

    @PostMapping("/{postId}/submit/{week}")
    public @ResponseBody LinkedHashMap<String, Object> submitPost(
            @PathVariable Long postId, @PathVariable int week
    ){
        return OutportMapper.toDto(postService.submitPost(postId, buddyId, week));
    }

    @PostMapping("/{postId}/feedback/{week}")
    public @ResponseBody LinkedHashMap<String, Object> completePostFeedback(
            @PathVariable Long postId, @PathVariable int week
    ){
        return OutportMapper.toDto(postService.buddyCompleteFeedback(postId, internId, week));
    }
}
