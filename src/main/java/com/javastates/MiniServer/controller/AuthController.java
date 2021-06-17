package com.javastates.MiniServer.controller;

import com.javastates.MiniServer.model.member.LoginDTO;
import com.javastates.MiniServer.service.AuthService;
import com.javastates.MiniServer.service.AuthServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    AuthService authService = new AuthServiceImpl();

    @PostMapping()
    public boolean login(@RequestBody LoginDTO loginDTO) {
        return authService.validate(loginDTO.getUserName(), loginDTO.getUserPw());
    }
}
