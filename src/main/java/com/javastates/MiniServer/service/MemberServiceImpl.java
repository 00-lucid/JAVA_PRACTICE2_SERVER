package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.member.Member;
import com.javastates.MiniServer.respository.MemberRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRespository memberRespository;

    @Override
    public void join(Member member) {
        memberRespository.save(member);
    }

    @Override
    public Member findById(UUID uuid) {
        return memberRespository.findMemberById(uuid);
    }

    @Override
    public ArrayList<Member> findAllMember() {
        return memberRespository.findAllMember();
    }
}
