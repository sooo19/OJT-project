package com.example.server.domain.controller;

import com.example.server.domain.service.MemberService;
import com.example.server.domain.util.OutportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final Long internId = 1L;
    private final Long buddyId = 2L;

    @GetMapping("/{memberId}")
    public @ResponseBody LinkedHashMap<String, Object> internWithBuddyInfo(@PathVariable Long memberId){
        if(memberId == internId){
            // 인턴
            return OutportMapper.toDto(memberService.getInternWithBuddyInfo(memberId));
        }else if(memberId == buddyId){
            return OutportMapper.toDto(memberService.getBuddyWithInternInfo(memberId));
        }
        throw new RuntimeException("서비스 확장 Point - 인증 인가 적용 및 Thread Local 활용 필요");
    }
}
