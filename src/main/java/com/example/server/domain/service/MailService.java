package com.example.server.domain.service;

import com.example.server.domain.service.dto.MailDto;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {
    private JavaMailSender javaMailSender;
    private static final String hanwhaMail = "@hanwha.com";

    public void mailSendToBuddy(String circleId, int week, String internName){
        SimpleMailMessage message = new SimpleMailMessage();
        MailDto mailDto = new MailDto(
                circleId.concat(hanwhaMail),
                internName.concat(" - ").concat(String.valueOf(week)).concat("주차 주간 보고서가 작성되었습니다."),
                "보고서가 제출되었습니다 피드백 이후 피드백 완료 버튼을 눌러주세요"
        );
        message.setTo(mailDto.address());
        message.setSubject(mailDto.title());
        message.setText(mailDto.message());
        javaMailSender.send(message);
    }


    public void mailSendToIntern(String circleId, int week, String buddyName){
        SimpleMailMessage message = new SimpleMailMessage();
        MailDto mailDto = new MailDto(
                circleId.concat(hanwhaMail),
                buddyName.concat(" - ").concat(String.valueOf(week)).concat("주차 주간 보고서 피드백이 작성되었습니다."),
                "피드백이 작성되었습니다 확인해 주세요"
        );
        message.setTo(mailDto.address());
        message.setSubject(mailDto.title());
        message.setText(mailDto.message());
        javaMailSender.send(message);
    }
}
