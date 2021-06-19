package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.member.Member;
import com.javastates.MiniServer.respository.MemberMemoryRespository;
import com.javastates.MiniServer.respository.MemberRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final MemberRespository memberRespository;

    public boolean validate(String userName, String userPw) {
        ArrayList<Member> memberArrayList = memberRespository.findAllMember();
        // 효율적으로 할 수 없을까..
        for (Member member : memberArrayList) {
            if (member.getUserName() == userName && member.getUserPw() == userPw) {
                return true;
            }
        }
        return false;
    }
}
