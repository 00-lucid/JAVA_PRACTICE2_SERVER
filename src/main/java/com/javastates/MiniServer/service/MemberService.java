package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.member.Member;

import java.util.*;


public interface MemberService {

    void join(Member member);

    Member findById(UUID uuid);

    ArrayList<Member> findAllMember();
}
