package com.tdd.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int parentId;
    private String content;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Members member;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    boolean deleted;
    boolean is_secret;

    public Comment() {
    }

    public Comment(long id, int parentId, String content, Members member, LocalDateTime created_at, LocalDateTime updated_at, boolean deleted, boolean is_secret) {
        this.id = id;
        this.parentId = parentId;
        this.content = content;
        this.member = member;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted = deleted;
        this.is_secret = is_secret;
    }    

    public long getId() {
        return this.id;
    }

    public int getParentId() {
        return this.parentId;
    }

    public String getContent() {
        return this.content;
    }

    public Members getMember() {
        return this.member;
    }

    public LocalDateTime getCreatedAt() {
        return this.created_at;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updated_at;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public boolean isSecret() {
        return this.is_secret;
    }

}
