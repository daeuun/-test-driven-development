package com.tdd.service;

import com.tdd.domain.Members;
import com.tdd.domain.MembersRepository;
import com.tdd.dto.MemberCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MembersServiceTest {
    private final MembersService membersService;
    private final MembersRepository membersRepository;

    @Autowired
    public MembersServiceTest(MembersService membersService, MembersRepository membersRepository) {
        this.membersService = membersService;
        this.membersRepository = membersRepository;
    }

    @Test
    @DisplayName("user1이 가입한다")
    void save() {
        //given
        MemberCreateRequest request = new MemberCreateRequest(100L, "user1");
        //when
        membersService.save(request);
        //then
        List<Members> members = membersRepository.findAll();
        assertThat(members).hasSize(1);
    }
}
