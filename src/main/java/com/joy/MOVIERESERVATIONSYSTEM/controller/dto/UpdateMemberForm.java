package com.joy.MOVIERESERVATIONSYSTEM.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UpdateMemberForm {


    private Long id;

    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String name;

    @NotEmpty(message = "이메일은 필수 입니다")
    private String eMail;

    @NotEmpty(message = "전화번호는 필수 입니다")
    private String phoneNumber;

}
