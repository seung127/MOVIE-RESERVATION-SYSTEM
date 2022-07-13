package com.joy.MOVIERESERVATIONSYSTEM.controller;

import com.joy.MOVIERESERVATIONSYSTEM.controller.dto.UpdateMemberForm;
import com.joy.MOVIERESERVATIONSYSTEM.domain.member.Member;
import com.joy.MOVIERESERVATIONSYSTEM.domain.movie.Movie;
import com.joy.MOVIERESERVATIONSYSTEM.service.MemberService;
import com.joy.MOVIERESERVATIONSYSTEM.controller.dto.MemberForm;
import com.joy.MOVIERESERVATIONSYSTEM.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Member member = new Member();
        member.setName(form.getName());
        member.setLoginId(form.getLoginId());
        member.setPassword(form.getPassword());
        member.setEMail(form.getEMail());
        member.setPhoneNumber(form.getPhoneNumber());
        memberService.join(member);
        return "redirect:/";

    }


    @GetMapping(value = "/members/list")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/list";
    }


    @GetMapping(value = "/members/{memberId}/edit")
    public String updateItemForm(@PathVariable("memberId") Long memberId, Model model) {
        Member member = memberService.findOne(memberId).get();
        UpdateMemberForm form = new UpdateMemberForm();
        form.setId(member.getId());
        form.setName(member.getName());
        form.setEMail(member.getEMail());
        form.setPhoneNumber(member.getPhoneNumber());
        model.addAttribute("form", form);
        return "members/updatememberForm";
    }


    @PostMapping(value = "/members/{memberId}/edit")
    public String updateItem(@ModelAttribute("form") UpdateMemberForm form) {
        memberService.updateMember(form.getId(), form.getName(), form.getEMail(),form.getPhoneNumber());
        return "redirect:/members/list";
    }

}
