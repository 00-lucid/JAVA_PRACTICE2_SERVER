package com.javastates.MiniServer.model.member;

import lombok.*;

@Data
@ToString
public class Member {
    private String userPw;
    private String userName;
    private int userAge;

    public Member(String userPw, String userName, int userAge) {
        this.userPw = userPw;
        this.userName = userName;
        this.userAge = userAge;
    }
}
