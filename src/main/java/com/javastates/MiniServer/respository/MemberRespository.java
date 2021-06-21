package com.javastates.MiniServer.respository;

import com.javastates.MiniServer.domain.member.Member;

import java.util.*;

public interface MemberRespository {

    UUID save(Member member);

    Member findMemberById(UUID uuid);

    ArrayList<Member> findAllMember();

    Member remove(UUID uuid);

    String getToken(String userName, String userPw);

    Member update(UUID uuid, Object object);
}
