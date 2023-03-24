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
    private boolean deleted;

    public Members() {
    }

    public Members(Long memberId, String nickname) {
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
