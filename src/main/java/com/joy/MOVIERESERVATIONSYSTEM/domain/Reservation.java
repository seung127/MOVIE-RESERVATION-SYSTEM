package com.joy.MOVIERESERVATIONSYSTEM.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Reservation {

    @Id @GeneratedValue
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private LocalDateTime reservationDate;

    private int count;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status; //주문상태 [ORDER, CANCEL]

    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getReservations().add(this);
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
        member.getReservations().add(this);
    }

}
