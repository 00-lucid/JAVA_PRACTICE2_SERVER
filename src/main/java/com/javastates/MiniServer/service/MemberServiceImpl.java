package com.javastates.MiniServer.service;

import com.javastates.MiniServer.domain.member.Member;
import com.javastates.MiniServer.domain.member.SignUpDTO;
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
        try {
            memberRespository.save(member);
        } catch (Exception e) {

        }
    }

    @Override
    public Member findById(UUID uuid) {
        try {
            return memberRespository.findMemberById(uuid);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Member> findAllMember() {
        try {
            return memberRespository.findAllMember();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Member updateMember(UUID uuid, Object object) {
        try {
            return memberRespository.update(uuid, object);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Member removeMember(UUID uuid) {
        try {
            return memberRespository.remove(uuid);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UUID addMember(SignUpDTO signUpDTO) {
        try {
            Member member = new Member(signUpDTO.getUserPw(), signUpDTO.getUserName(), signUpDTO.getUserAge());
            return memberRespository.save(member);
        } catch (Exception e) {
            return null;
        }
    }
}
