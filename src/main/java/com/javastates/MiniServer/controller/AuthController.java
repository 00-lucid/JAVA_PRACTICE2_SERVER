package com.javastates.MiniServer.controller;

import com.javastates.MiniServer.domain.member.ConfigVO;
import com.javastates.MiniServer.domain.member.LoginDTO;
import com.javastates.MiniServer.domain.member.Member;
import com.javastates.MiniServer.domain.member.SignUpDTO;
import com.javastates.MiniServer.service.AuthService;
import com.javastates.MiniServer.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AuthService authService;
    private final MemberService memberService;

    @PostMapping(value = "login")
    public String login(@RequestBody LoginDTO loginDTO) {
            logger.info(loginDTO.toString());
            return authService.validate(loginDTO.getUserName(), loginDTO.getUserPw());
    }

    @PostMapping(value = "signup")
    public UUID signup(@RequestBody SignUpDTO signUpDTO) {
            logger.info(signUpDTO.toString());
            return memberService.addMember(signUpDTO);
    }

    @DeleteMapping(value = "withdraw")
    public boolean withdraw(@RequestHeader(value = "authorization") UUID token) {
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
    public Member update(@RequestHeader(value = "authorization") UUID token, @RequestBody ConfigVO configVO) {
            logger.info(configVO.toString());
            return memberService.updateMember(token, configVO.getUserName());
    }

    @GetMapping(value = "info")
    public Member getInfo(@RequestHeader(value = "authorization") UUID token) {
            return memberService.findById(token);
    }
}
