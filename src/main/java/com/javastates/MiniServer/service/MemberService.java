package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.member.ConfigVO;
import com.javastates.MiniServer.model.member.Member;
import com.javastates.MiniServer.model.member.SignUpDTO;

import java.util.*;


public interface MemberService {

    void join(Member member);

    Member findById(UUID uuid);

    ArrayList<Member> findAllMember();

    Member updateMember(UUID uuid, Object object);

    Member removeMember(UUID uuid);

    UUID addMember(SignUpDTO signUpDTO);

}
