package com.javastates.MiniServer.service;


public interface AuthService {
    boolean validate(String userName, String userPw);
}
