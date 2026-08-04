package com.example.demo;

import com.example.demo.domain.post.entity.Post;
import com.example.demo.domain.post.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class PostRepositoryTest {

	@Autowired
	private PostRepository postRepository;

	@Test
	@DisplayName("2번 글 조회")
	void t1() {
		Post post1 = postRepository.findById(2).get();

		assertThat(post1.getId()).isEqualTo(2);
		assertThat(post1.getTitle()).isEqualTo("제목2");
		assertThat(post1.getBody()).isEqualTo("내용2");

	}
}
