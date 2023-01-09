package com.example.server.domain.controller;

import static com.example.server.domain.util.OutportMapper.*;

import com.example.server.domain.controller.dto.UpdatePostDto;
import com.example.server.domain.controller.dto.UpdatePostFeedbackDto;
import com.example.server.domain.service.PostService;
import com.example.server.domain.service.dto.InternUpdatePostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final Long internId = 1L;
    private final Long buddyId = 2L;

    @GetMapping
    public @ResponseBody LinkedHashMap<String, Object> posts(){
        return toDto(postService.getPosts(internId));
    }

    @GetMapping("/{postId}")
    public @ResponseBody LinkedHashMap<String, Object> post(
            @PathVariable Long postId
    ){
        return toDto(postService.getPost(postId));
    }

    @PostMapping("/intern/{postId}")
    public @ResponseBody LinkedHashMap<String, Object> updatePostContent(
            @PathVariable Long postId, @RequestBody UpdatePostDto updatePostDto
    ){
        InternUpdatePostDto internUpdatePostDto = new InternUpdatePostDto(updatePostDto.content(), updatePostDto.report());
        return toDto(postService.internUpdatePost(postId, internUpdatePostDto));
    }
    @PostMapping("/buddy/{postId}")
    public @ResponseBody LinkedHashMap<String, Object> updatePostFeedback(
            @PathVariable Long postId, @RequestBody UpdatePostFeedbackDto updatePostFeedbackDto
    ){
        return toDto(postService.buddyUpdatePost(postId, updatePostFeedbackDto.feedback()));
    }

    @PostMapping("/{postId}/submit/{week}")
    public @ResponseBody LinkedHashMap<String, Object> submitPost(
            @PathVariable Long postId, @PathVariable int week
    ){
        return toDto(postService.submitPost(postId, buddyId, week));
    }

    @PostMapping("/{postId}/feedback/{week}")
    public @ResponseBody LinkedHashMap<String, Object> completePostFeedback(
            @PathVariable Long postId, @PathVariable int week
    ){
        return toDto(postService.buddyCompleteFeedback(postId, internId, week));
    }
}
