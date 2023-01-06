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

    @GetMapping("/{memberId}")
    public MemberWithBuddyInfoDto internWithBuddyInfo(@PathVariable Long memberId){
        if(memberId == 1){
            // 인턴
            return memberService.getInternWithBuddyInfo(memberId);
        }
        return memberService.getBuddyWithInternInfo(memberId);
    }
}
