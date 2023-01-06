package com.example.server.domain.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", unique = true, nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "member_id")
    private Member member;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "week", nullable = false)
    private int week;

    @Column(name = "biz_part", nullable = false)
    private String bizPart;

    @Column(name = "team", nullable = false)
    private String team;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "buddy_position", nullable = false)
    private Position buddyPosition;

    @Column(name = "buddy_name", nullable = false)
    private String buddyName;

    @Column(name = "buddy_task", nullable = false)
    private String buddyTask;

    @Column(name = "content")
    private String content;

    @Column(name = "report")
    private String report;

    @Column(name = "feedbacl")
    private String feedback;

    @Column(name = "submit", nullable = false, length = 1)
    private String submit;
    @Column(name = "feedback_complete", nullable = false, length = 1)
    private String feedbackComplete;

    @Builder
    public Post(Long id, Member member, String name, LocalDateTime date, int week, String bizPart, String team, Position buddyPosition, String buddyName, String buddyTask, String content, String report, String feedback, String submit, String feedbackComplete) {
        this.id = id;
        this.member = member;
        this.name = name;
        this.date = date;
        this.week = week;
        this.bizPart = bizPart;
        this.team = team;
        this.buddyPosition = buddyPosition;
        this.buddyName = buddyName;
        this.buddyTask = buddyTask;
        this.content = content;
        this.report = report;
        this.feedback = feedback;
        this.submit = submit;
        this.feedbackComplete = feedbackComplete;
    }

    public void changePostContent(String content, String report){
        this.content = content;
        this.report = report;
    }

    public void changeFeedBack(String feedback){
        this.feedback = feedback;
    }

    public void submitPost(){
        this.submit = "1";
    }

    public void feedbackComplete(){
        this.feedbackComplete = "1";
    }
}
