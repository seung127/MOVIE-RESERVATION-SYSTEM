package com.joy.MOVIERESERVATIONSYSTEM.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String name;

    private String eMail;

    private String phoneNumber;

    @NotEmpty(message = "아이디 입력은 필수 입니다")
    private String loginId;

    @NotEmpty(message = "비밀번호 입력은 필수 입니다(-빼고 입력해주세요)")
    private String password;

}
