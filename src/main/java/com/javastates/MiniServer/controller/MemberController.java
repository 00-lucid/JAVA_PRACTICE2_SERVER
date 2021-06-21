package com.javastates.MiniServer.controller;

import com.javastates.MiniServer.domain.member.Member;
import com.javastates.MiniServer.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
@ResponseBody
@CrossOrigin(origins = "*", maxAge = 3600)
@Component
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/member")
    private Member getMember(@RequestParam UUID uuid) {
        try {
            return memberService.findById(uuid);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "/members")
    private ArrayList<Member> getMembers() {
        try {
            return memberService.findAllMember();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(value = "/member")
    private void addMember(@RequestBody Member member) {
        try {
            memberService.join(member);
        } catch (Exception e) {
            return;
        }
    }
}
