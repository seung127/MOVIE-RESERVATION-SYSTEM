package com.joy.MOVIERESERVATIONSYSTEM.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Movie {

    @Id
    @GeneratedValue
    @Column(name = "movie_id")
    private Long id;

    private int maxAudience;

    private int curAudience;

    private String title;

    private String director;

    private int cinemaNum;

    private String date;

    private String time;

    @Enumerated(EnumType.STRING)
    private Region region; //주문상태 [ORDER, CANCEL]

    @OneToMany(mappedBy = "movie")
    private List<Reservation> reservations = new ArrayList<>();




}
