package com.example.server.domain.service;

import com.example.server.domain.model.Member;
import com.example.server.domain.model.Position;
import com.example.server.domain.model.Post;
import com.example.server.domain.repository.MemberRepository;
import com.example.server.domain.repository.PostRepository;
import com.example.server.domain.service.Dto.MemberWithBuddyInfoDto;
import com.example.server.global.error.exception.MemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public void sampleJoin() {
        Member intern = Member.builder()
                .id(1L)
                .circleId("yong9753")
                .password("test1234")
                .employeeNumber(202204179L)
                .name("이용훈")
                .position(Position.INTERN)
                .bizPart("서비스혁신사업부")
                .team("제조운영2팀")
                .partnerId(2L)
                .build();

        Member buddy = Member.builder()
                .id(2L)
                .circleId("soorim18")
                .password("test1234")
                .employeeNumber(202204177L)
                .name("윤수림")
                .position(Position.STAFF)
                .bizPart("서비스혁신사업부")
                .team("제조운영2팀")
                .partnerId(1L)
                .build();

        memberRepository.save(intern);
        memberRepository.save(buddy);

        for (int i = 1; i <= 6; i++) {
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
                    .feedbackComplete("0")
                    .submit("0")
                    .build();
            postRepository.save(post);
        }
    }

    public MemberWithBuddyInfoDto getInternWithBuddyInfo(Long internId) {
        Member intern = memberRepository.findById(internId)
                .orElseThrow(() -> {
                    throw MemberException.notFoundMember(internId);
                });

        Long buddyId = intern.getPartnerId();
        Member buddy = memberRepository.findById(buddyId)
                .orElseThrow(() -> {
                    throw MemberException.notFoundMember(buddyId);
                });

        return new MemberWithBuddyInfoDto(intern, buddy);
    }


    public MemberWithBuddyInfoDto getBuddyWithInternInfo(Long buddyId) {
        Member buddy = memberRepository.findById(buddyId)
                .orElseThrow(() -> {
                    throw MemberException.notFoundMember(buddyId);
                });

        Long internId = buddy.getPartnerId();
        Member intern = memberRepository.findById(buddyId)
                .orElseThrow(() -> {
                    throw MemberException.notFoundMember(internId);
                });

        return new MemberWithBuddyInfoDto(intern, buddy);
    }

}
