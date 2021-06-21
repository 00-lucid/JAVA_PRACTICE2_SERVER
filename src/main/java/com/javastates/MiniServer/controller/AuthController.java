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
        try {
            System.out.println(loginDTO);
            return authService.validate(loginDTO.getUserName(), loginDTO.getUserPw());
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(value = "signup")
    public UUID signup(@RequestBody SignUpDTO signUpDTO) {
        try {
            System.out.println(signUpDTO);
            return memberService.addMember(signUpDTO);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping(value = "withdraw")
    public boolean withdraw(@RequestHeader(value = "authorization") UUID token) {
        try {
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
        } catch (Exception e) {
            return false;
        }
    }

    @PatchMapping(value = "update")
    public Member update(@RequestHeader(value = "authorization") UUID token, @RequestBody Object object) {
        try {
            System.out.println(object);
            return memberService.updateMember(token, object);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "info")
    public Member getInfo(@RequestHeader(value = "authorization") UUID token) {
        try {
            return memberService.findById(token);
        } catch (Exception e) {
            return null;
        }
    }
}
