package com.tdd.service;


import com.tdd.domain.Members;
import com.tdd.domain.MembersRepository;
import com.tdd.dto.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdd.domain.CommentRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final MembersRepository memberRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, MembersRepository membersRepository) {
        this.commentRepository = commentRepository;
        this.memberRepository = membersRepository;
    }

    @Transactional
    public void save(Long memberId, CommentRequest request) {
        Members member = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원임다"));
        commentRepository.save(request.toEntity(member));
    }
}
