package com.example.server.domain.controller;

import com.example.server.domain.service.dto.MemberWithBuddyInfoDto;
import com.example.server.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final Long internId = 1L;
    private final Long buddyId = 2L;

    @GetMapping("/{memberId}")
    public MemberWithBuddyInfoDto internWithBuddyInfo(@PathVariable Long memberId){
        if(memberId == internId){
            // 인턴
            return memberService.getInternWithBuddyInfo(memberId);
        }else if(memberId == buddyId){
            return memberService.getBuddyWithInternInfo(memberId);
        }
        throw new RuntimeException("서비스 확장 Point - 인증 인가 적용 및 Thread Local 활용 필요");
    }
}
