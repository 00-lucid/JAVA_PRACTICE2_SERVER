package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.member.Member;
import com.javastates.MiniServer.model.member.SignUpDTO;
import com.javastates.MiniServer.respository.MemberRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final MemberRespository memberRespository;

    @Override
    public String validate(String userName, String userPw) {
//        ArrayList<Member> memberArrayList = memberRespository.findAllMember();
//        // 효율적으로 할 수 없을까..
//        for (Member member : memberArrayList) {
//            if (member.getUserName().equals(userName) && member.getUserPw().equals(userPw)) {
//                return true;
//            }
//        }
//        return false;
        return memberRespository.getToken(userName, userPw);
    }

}
