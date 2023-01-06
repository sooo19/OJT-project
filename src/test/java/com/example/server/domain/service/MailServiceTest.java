package com.example.server.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailServiceTest {
    @Autowired
    MailService mailService;

    @Test
    @DisplayName("mail 전송 테스트")
    void mailTest() throws Exception {
        //given
        String circleId = "yong9753";
        int week = 1;
        String internName = "이용훈";

        //when
        mailService.mailSendToBuddy(circleId, week, internName);


        //then

    }
}