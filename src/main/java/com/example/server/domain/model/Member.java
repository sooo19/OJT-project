package com.example.server.domain.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "circle_id", nullable = false)
    private String circleId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "employee_number", nullable = false)
    private Long employeeNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name ="biz_part", nullable = false)
    private String bizPart;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "position", nullable = false)
    private Position position;

    @Column(name = "team", nullable = false)
    private String team;

    @Column(name = "partner_id")
    private Long partnerId;

    @Builder
    public Member(Long id, String circleId, String password, Long employeeNumber, String name, String bizPart, Position position, String team, Long partnerId) {
        this.id = id;
        this.circleId = circleId;
        this.password = password;
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.bizPart = bizPart;
        this.position = position;
        this.team = team;
        this.partnerId = partnerId;
    }
}
