package com.javastates.MiniServer.domain.member;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ConfigVO {
    private String userName;

    public ConfigVO(String userName) {
        this.userName = userName;
    }
}
