package com.example.server.domain.model;

public enum Position {
    INTERN("인턴"),
    STAFF("사원"),
    ASSISTANT_MANAGER("대리"),
    MANAGER("과장"),
    GENERAL("부장");

    private final String koreanPosition;

    Position(String koreanPosition) {
        this.koreanPosition = koreanPosition;
    }
}
