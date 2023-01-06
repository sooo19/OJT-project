package com.example.server.domain.service.Dto;

import com.example.server.domain.model.Member;

public record MemberWithBuddyInfoDto(
        Member intern,
        Member buddy
) {
}
