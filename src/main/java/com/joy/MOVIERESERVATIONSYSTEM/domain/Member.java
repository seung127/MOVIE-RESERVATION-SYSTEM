package com.joy.MOVIERESERVATIONSYSTEM.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String eMail;

    private String phoneNumber;

    private String loginId;

    private String password;

    @OneToMany(mappedBy = "member")
    private List<Reservation> reservations = new ArrayList<>();
}
