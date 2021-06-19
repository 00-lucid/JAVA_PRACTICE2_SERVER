package com.javastates.MiniServer.model.member;

import lombok.*;

@Getter
@Setter
@ToString
public class LoginDTO {
    private String userName;
    private String userPw;

    public LoginDTO(String userName, String userPw) {
        this.userName = userName;
        this.userPw = userPw;
    }
}
