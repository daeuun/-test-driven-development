package com.tdd.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tdd.domain.Comment;
import com.tdd.domain.CommentRepository;
import com.tdd.domain.Members;
import com.tdd.domain.MembersRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class CommentServiceTest {

    private static Members user1;
    private final CommentRepository commentRepository;
    private final CommentService commentService;
    private final MembersRepository membersRepository;

    @Autowired
    public CommentServiceTest(CommentRepository commentRepository, CommentService commentService, MembersRepository membersRepository) {
        this.commentRepository = commentRepository;
        this.commentService = commentService;
        this.membersRepository = membersRepository;
    }

    @BeforeEach
     void setUp() {
        user1 = new Members(1L, 100L, "user1");
        user1 = membersRepository.save(user1);
    }

    @Test
    @DisplayName("user1이 첫번째 댓글을 작성한다.")
    void saveFirstComment() {
        //given
        Comment comment = new Comment(user1.getMemberId(), -1, "first comment", user1, LocalDateTime.now(), LocalDateTime.now(), false, false);
        //when
        commentService.save(comment);
        //then
        List<Comment> results = commentRepository.findAll();
        assertThat(results).hasSize(1);
    }

}
