package com.javastates.MiniServer.respository;

import com.javastates.MiniServer.model.member.Member;

import java.util.*;

public interface MemberRespository {

    void save(Member member);

    Member findMemberById(UUID uuid);

    ArrayList<Member> findAllMember();
}
