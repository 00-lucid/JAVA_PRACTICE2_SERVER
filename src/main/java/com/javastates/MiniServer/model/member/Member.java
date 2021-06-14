package com.javastates.MiniServer.model.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String userId;
    private String userPw;
    private String userName;
    private int userAge;

    public Member(String userId, String userPw, String userName, int userAge) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userAge = userAge;
    }
}
