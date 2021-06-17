package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.member.Member;
import com.javastates.MiniServer.respository.MemberMemoryRespository;
import com.javastates.MiniServer.respository.MemberRespository;

import java.util.ArrayList;

public class AuthServiceImpl implements AuthService{

    MemberRespository memberMemoryRespository = new MemberMemoryRespository();

    public boolean validate(String userName, String userPw) {
        ArrayList<Member> memberArrayList = memberMemoryRespository.findAllMember();
        // 효율적으로 할 수 없을까..
        for (Member member : memberArrayList) {
            if (member.getUserName() == userName && member.getUserPw() == userPw) {
                return true;
            }
        }
        return false;
    }
}
