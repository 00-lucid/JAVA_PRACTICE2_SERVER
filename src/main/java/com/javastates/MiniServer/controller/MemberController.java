package com.javastates.MiniServer.controller;

import com.javastates.MiniServer.model.member.Member;
import com.javastates.MiniServer.service.MemberService;
import com.javastates.MiniServer.service.MemberServiceImpl;
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
        return memberService.findById(uuid);
    }

    @GetMapping(value = "/members")
    private ArrayList<Member> getMembers() {
        return memberService.findAllMember();
    }

    @PostMapping(value = "/member")
    private void addMember(@RequestBody Member member) {
        memberService.join(member);
    }
}
