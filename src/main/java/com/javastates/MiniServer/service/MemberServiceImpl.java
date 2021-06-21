package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.member.ConfigVO;
import com.javastates.MiniServer.model.member.Member;
import com.javastates.MiniServer.model.member.SignUpDTO;
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

    @Override
    public Member updateMember(UUID uuid, Object object) {
        return memberRespository.update(uuid, object);
    }

    @Override
    public Member removeMember(UUID uuid) {
        return memberRespository.remove(uuid);
    }

    @Override
    public UUID addMember(SignUpDTO signUpDTO) {
        Member member = new Member(signUpDTO.getUserPw(), signUpDTO.getUserName(), signUpDTO.getUserAge());
        return memberRespository.save(member);
    }
}
