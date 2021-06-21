package com.javastates.MiniServer.domain.member;

import lombok.*;

@Getter
@ToString
public class LoginDTO {
    private String userName;
    private String userPw;

    public LoginDTO(String userName, String userPw) {
        this.userName = userName;
        this.userPw = userPw;
    }
}
