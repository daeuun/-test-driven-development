package com.tdd.service;

import com.tdd.dto.CommentRequest;
import com.tdd.dto.MemberCreateRequest;
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

    private final CommentRepository commentRepository;
    private final CommentService commentService;
    private final MembersRepository membersRepository;
    private final MembersService membersService;

    @Autowired
    public CommentServiceTest(CommentRepository commentRepository, CommentService commentService, MembersRepository membersRepository, MembersService membersService) {
        this.commentRepository = commentRepository;
        this.commentService = commentService;
        this.membersRepository = membersRepository;
        this.membersService = membersService;
    }

    @Test
    @DisplayName("user1이 첫번째 댓글을 작성한다.")
    void saveFirstComment() {
        //given
        membersService.save(new MemberCreateRequest(100L, "user1"));
        Members user1 = membersRepository.findByMemberId(100L).orElseThrow(() -> new IllegalArgumentException("user1 없는 회원"));
        CommentRequest comment = new CommentRequest(-1, "first comment", LocalDateTime.now(), LocalDateTime.now(), false, false);
        //when
        commentService.save(user1.getMemberId(), comment);
        //then
        List<Comment> comments = commentRepository.findAll();
        assertThat(comments).hasSize(1);
    }

}
