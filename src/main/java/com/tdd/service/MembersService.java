package com.tdd.service;

import com.tdd.domain.Members;
import com.tdd.domain.MembersRepository;
import com.tdd.dto.MemberCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MembersService {
    private final MembersRepository membersRepository;

    @Autowired
    public MembersService(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    @Transactional
    public void save(MemberCreateRequest request) {
        membersRepository.save(request.toEntity());
    }

}
