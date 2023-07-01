package com.example.simple_member.controller;


import com.example.simple_member.service.MemberService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.simple_member.domain.Member;

import java.util.List;

@org.springframework.stereotype.Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/members/new")
    public String signup(){
        return "memberjoin";
    }

    @PostMapping("/members/new")
    public String createForm(memberForm mem){
        Member member = new Member();
        member.setName(mem.getName());
        memberService.join(member);
        System.out.println(mem.getName());
        return "redirect:/";
    }
    @GetMapping("/members")
    public String showup(Model model){

        model.addAttribute("members", memberService.showAll());

        return "memberinfo";

    }
}
