package com.tdd.dto;

import com.tdd.domain.Comment;
import com.tdd.domain.Members;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class CommentRequest {
    private int parentId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;
    private boolean isSecret;

    public Comment toEntity(Members member) {
        return new Comment(parentId, content, member, createdAt, updatedAt, deleted, isSecret);
    }
}
