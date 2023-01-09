package com.example.server.domain.service;

import com.example.server.domain.model.Member;
import com.example.server.domain.model.Position;
import com.example.server.domain.model.Post;
import com.example.server.domain.repository.MemberRepository;
import com.example.server.domain.repository.PostRepository;
import com.example.server.domain.service.dto.MemberWithBuddyInfoDto;
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
