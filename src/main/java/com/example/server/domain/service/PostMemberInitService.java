package com.example.server.domain.service;

import com.example.server.domain.model.Member;
import com.example.server.domain.model.Position;
import com.example.server.domain.model.Post;
import com.example.server.domain.repository.MemberRepository;
import com.example.server.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class PostMemberInitService {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public void sampleJoin() {
        Member intern = Member.builder()
                .id(1L)
                .circleId("yong9753")
                .password("test1234")
                .employeeNumber(202204179L)
                .name("이용훈")
                .position(Position.STAFF)
                .bizPart("서비스혁신사업부")
                .team("제조운영2팀 테크윈 파트")
                .partnerId(2L)
                .build();

        Member buddy = Member.builder()
                .id(2L)
                .circleId("soorim18")
                .password("test1234")
                .employeeNumber(202204177L)
                .name("윤수림")
                .position(Position.ASSISTANT_MANAGER)
                .bizPart("서비스혁신사업부")
                .team("제조운영2팀 테크윈파트")
                .partnerId(1L)
                .build();

        memberRepository.save(intern);
        memberRepository.save(buddy);

        // 내용 쓰고, feedback 완료 -> checked, checked
        Post post1 = Post.builder()
                .member(intern)
                .name(intern.getName())
                .date(LocalDateTime.now())
                .week(1)
                .bizPart(intern.getBizPart())
                .team(intern.getTeam())
                .buddyPosition(buddy.getPosition())
                .buddyName(buddy.getName())
                .buddyTask(buddy.getBizPart().concat(" - ").concat(buddy.getTeam()))
                .content("content complete")
                .report("report complete")
                .feedbackComplete("1")
                .submit("1")
                .build();
        postRepository.save(post1);

        // 내용만 작성, -> checked, unchecked
        Post post2 = Post.builder()
                .member(intern)
                .name(intern.getName())
                .date(LocalDateTime.now())
                .week(1)
                .bizPart(intern.getBizPart())
                .team(intern.getTeam())
                .buddyPosition(buddy.getPosition())
                .buddyName(buddy.getName())
                .buddyTask(buddy.getBizPart().concat(" - ").concat(buddy.getTeam()))
                .content("content complete")
                .report("")
                .feedbackComplete("1")
                .submit("0")
                .build();
        postRepository.save(post1);

        for (int i = 3; i <= 6; i++) {
            Post post = Post.builder()
                    .member(intern)
                    .name(intern.getName())
                    .date(LocalDateTime.now())
                    .week(i)
                    .bizPart(intern.getBizPart())
                    .team(intern.getTeam())
                    .buddyPosition(buddy.getPosition())
                    .buddyName(buddy.getName())
                    .buddyTask(buddy.getBizPart().concat(" - ").concat(buddy.getTeam()))
                    .content("content complete")
                    .report("report complete")
                    .feedbackComplete("1")
                    .submit("1")
                    .build();
            postRepository.save(post);
        }
    }
}
