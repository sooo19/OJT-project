package com.example.server.domain.service.dto;

public record MailDto (
        String address,
        String title,
        String message
) {
}
