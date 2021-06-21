package com.javastates.MiniServer.controller;

import com.javastates.MiniServer.model.member.ConfigVO;
import com.javastates.MiniServer.model.member.LoginDTO;
import com.javastates.MiniServer.model.member.Member;
import com.javastates.MiniServer.model.member.SignUpDTO;
import com.javastates.MiniServer.service.AuthService;
import com.javastates.MiniServer.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@ResponseBody
@CrossOrigin(origins = "*", maxAge = 3600)
@Component
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final MemberService memberService;

    @PostMapping(value = "login")
    public String login(@RequestBody LoginDTO loginDTO) {
        System.out.println(loginDTO);
        return authService.validate(loginDTO.getUserName(), loginDTO.getUserPw());
    }

    @PostMapping(value = "signup")
    public UUID signup(@RequestBody SignUpDTO signUpDTO) {
        System.out.println(signUpDTO);
        return memberService.addMember(signUpDTO);
    }

    @DeleteMapping(value = "withdraw")
    public boolean withdraw(@RequestHeader(value = "authorization") UUID token) {
        System.out.println(token);
        if (token.toString().isEmpty()) {
            return false;
        } else {
            Member member = memberService.removeMember(token);
            if (member.toString().isEmpty()) {
                return false;
            }
            return true;
        }
    }

    @PatchMapping(value = "update")
    public Member update(@RequestHeader(value = "authorization") UUID token, @RequestBody Object object) {
        System.out.println(object);
        return memberService.updateMember(token, object);
    }

    @GetMapping(value = "info")
    public Member getInfo(@RequestHeader(value = "authorization") UUID token) {
        return memberService.findById(token);
    }
}
