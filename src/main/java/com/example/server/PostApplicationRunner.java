package com.example.server;

import com.example.server.domain.service.PostMemberInitService;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostApplicationRunner implements ApplicationRunner {
    private final PostMemberInitService postMemberInitService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        postMemberInitService.sampleJoin();
    }
}
