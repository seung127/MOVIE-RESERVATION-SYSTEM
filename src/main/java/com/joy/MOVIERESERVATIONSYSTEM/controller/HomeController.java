package com.joy.MOVIERESERVATIONSYSTEM.controller;

import com.joy.MOVIERESERVATIONSYSTEM.controller.dto.SessionConst;
import com.joy.MOVIERESERVATIONSYSTEM.domain.member.Member;
import com.joy.MOVIERESERVATIONSYSTEM.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String home(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {

        //세션에 회원 데이터가 없으면 home
        if (loginMember == null) {
            return "home";
        }

        //세션이 유지되면 로그인으로 이동
        model.addAttribute("member", loginMember);
        return "loginhome";
    }
}
