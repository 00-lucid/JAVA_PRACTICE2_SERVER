package com.javastates.MiniServer.model.member;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SignUpDTO {
    private String userName;
    private String userPw;
    private int userAge;

    public SignUpDTO(String userName, String userPw, int userAge) {
        this.userName = userName;
        this.userPw = userPw;
        this.userAge = userAge;
    }
}
