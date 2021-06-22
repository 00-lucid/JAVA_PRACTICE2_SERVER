package com.javastates.MiniServer.service;

import com.javastates.MiniServer.domain.member.ConfigVO;
import com.javastates.MiniServer.domain.member.Member;
import com.javastates.MiniServer.domain.member.SignUpDTO;

import java.util.*;


public interface MemberService {

    void join(Member member);

    Member findById(UUID uuid);

    ArrayList<Member> findAllMember();

    Member updateMember(UUID uuid, String userName);

    Member removeMember(UUID uuid);

    UUID addMember(SignUpDTO signUpDTO);

}
