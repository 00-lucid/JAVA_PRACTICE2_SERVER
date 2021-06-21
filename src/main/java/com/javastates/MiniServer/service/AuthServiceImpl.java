package com.javastates.MiniServer.service;

import com.javastates.MiniServer.respository.MemberRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final MemberRespository memberRespository;

    @Override
    public String validate(String userName, String userPw) {
        try {
            return memberRespository.getToken(userName, userPw);
        } catch (Exception e) {
            return null;
        }
    }

}
