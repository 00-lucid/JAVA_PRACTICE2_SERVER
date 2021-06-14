package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.member.Member;
import com.javastates.MiniServer.respository.MemberMemoryRespository;
import com.javastates.MiniServer.respository.MemberRespository;

import java.util.ArrayList;
import java.util.UUID;

public class MemberServiceImpl implements MemberService{

    MemberRespository memberRespository = new MemberMemoryRespository();

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
