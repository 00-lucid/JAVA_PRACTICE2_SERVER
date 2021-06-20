package com.javastates.MiniServer.service;


import com.javastates.MiniServer.model.member.Member;
import com.javastates.MiniServer.model.member.SignUpDTO;

import java.util.UUID;

public interface AuthService {

    String validate(String userName, String userPw);



}
