package com.example.server.domain.service.Dto;

public record MailDto (
        String address,
        String title,
        String message
) {
}
