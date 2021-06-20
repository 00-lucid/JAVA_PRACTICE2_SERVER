package com.javastates.MiniServer.respository;

import com.javastates.MiniServer.model.member.LoginDTO;
import com.javastates.MiniServer.model.member.Member;

import java.util.*;

public interface MemberRespository {

    UUID save(Member member);

    Member findMemberById(UUID uuid);

    ArrayList<Member> findAllMember();

    Member remove(UUID uuid);

    String getToken(String userName, String userPw);

    Member update(UUID uuid, String newName);
}
