package com.example.server.domain.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.server.domain.model.Post;
import com.example.server.domain.service.dto.InternUpdatePostDto;

@SpringBootTest
class PostServiceTest {
	@Autowired
	PostService postService;

	@Test
	void internUpdatePostTest () {
	    // given
		Long postId = 1L;
		String updatedContent = "new content";
		String updatedReport = "new report";
		InternUpdatePostDto internUpdatePostDto = new InternUpdatePostDto(updatedContent, updatedReport);

	    // when
		Post post = postService.internUpdatePost(postId, internUpdatePostDto);

		// then
		Assertions.assertThat(post.getContent()).isEqualTo(updatedContent);
		Assertions.assertThat(post.getReport()).isEqualTo(updatedReport);
	}

}