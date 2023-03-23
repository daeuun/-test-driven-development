package com.tdd.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long memberId;
    private String nickname;

    public Members() {
    }

    public Members(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public Members(long id, long memberId, String nickname) {
        this.id = id;
        this.memberId = memberId;
        this.nickname = nickname;
    }

    public Long getId() {
        return this.id;
    }

    public Long getMemberId() {
        return this.memberId;
    }

    public String getNickname() {
        return this.nickname;
    }
}
