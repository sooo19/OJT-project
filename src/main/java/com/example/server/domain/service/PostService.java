package com.example.server.domain.service;

import com.example.server.domain.model.Member;
import com.example.server.domain.repository.MemberRepository;
import com.example.server.domain.model.Post;
import com.example.server.domain.repository.PostRepository;
import com.example.server.domain.service.Dto.InternUpdatePostDto;
import com.example.server.global.error.exception.MemberException;
import com.example.server.global.error.exception.PostException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final MailService mailService;

    public List<Post> getPosts(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> {
                    throw MemberException.notFoundMember(memberId);
                });
        List<Post> posts = postRepository.findByMember(member);
        return posts;
    }

    public Post getPost(Long postId){
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> {
                    throw PostException.notFoundPost(postId);
                });
        return post;
    }

    public Post internUpdatePost(Long postId, InternUpdatePostDto internUpdatePostDto){
        Post post = getPost(postId);
        post.changePostContent(internUpdatePostDto.content(), internUpdatePostDto.report());
        return post;
    }

    public Post submitPost(Long postId, Long buddyId, int week){
        // 버디에게 메일 전송
        Member buddy = memberRepository.findById(buddyId)
                .orElseThrow(() -> {
                    throw MemberException.notFoundMember(buddyId);
                });

        Long internId = buddy.getPartnerId();
        Member intern = memberRepository.findById(internId)
                .orElseThrow(() -> {
                    throw MemberException.notFoundMember(internId);
                });

        mailService.mailSendToBuddy(buddy.getCircleId(), week, intern.getName());
        //
        Post post = getPost(postId);
        post.submitPost();
        return post;
    }

    public Post buddyUpdatePost(Long postId, String feedback){
        Post post = getPost(postId);
        post.changeFeedBack(feedback);
        return post;
    }

    public Post buddyCompleteFeedback(Long postId, Long internId, int week){
        // 인턴에게 메일 전송
        Member intern = memberRepository.findById(internId)
                .orElseThrow(() -> {
                    throw MemberException.notFoundMember(internId);
                });

        Long buddyId = intern.getPartnerId();
        Member buddy = memberRepository.findById(buddyId)
                .orElseThrow(() -> {
                    throw MemberException.notFoundMember(buddyId);
                });

        mailService.mailSendToIntern(intern.getCircleId(), week, buddy.getName());
        //
        Post post = getPost(postId);
        post.feedbackComplete();
        return post;
    }

}
