package com.tdd.dto;

import com.tdd.domain.Members;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MemberCreateRequest {
    private Long MemberId;
    private String nickname;

    public Members toEntity() {
        return new Members(this.getMemberId(), this.getNickname());
    }
}
