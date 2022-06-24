package com.joy.MOVIERESERVATIONSYSTEM.domain.reservation;

import com.joy.MOVIERESERVATIONSYSTEM.domain.member.Member;
import com.joy.MOVIERESERVATIONSYSTEM.domain.movie.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

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

    protected Reservation() {
    }

    //==생성 메서드==//
    public static Reservation createReservation(Member member, Movie movie,int count){
        Reservation reservation = new Reservation();
        reservation.setMember(member);
        reservation.setMovie(movie);
        reservation.setCount(count);
        reservation.setStatus(ReservationStatus.RESERVATION);
        reservation.setReservationDate(LocalDateTime.now());

        movie.reservationSeat(count);

        return reservation;
    }


    //==비즈니스 로직==//
    /**예매취소**/
    public void cancel(){
        this.setStatus(ReservationStatus.CANCEL);
        movie.cancel(count);
    }


    //==조회 로직==//
    /**전체 주문 가격 조회**/
    public int getTotalPrice(){
        int totalPrice=0;
        totalPrice=count*movie.getPrice();

        return totalPrice;
    }


}
