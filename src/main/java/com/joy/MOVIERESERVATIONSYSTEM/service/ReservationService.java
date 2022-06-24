package com.joy.MOVIERESERVATIONSYSTEM.service;


import com.joy.MOVIERESERVATIONSYSTEM.domain.member.Member;
import com.joy.MOVIERESERVATIONSYSTEM.domain.movie.Movie;
import com.joy.MOVIERESERVATIONSYSTEM.domain.reservation.Reservation;
import com.joy.MOVIERESERVATIONSYSTEM.repository.MemberRepository;
import com.joy.MOVIERESERVATIONSYSTEM.repository.MovieRepository;
import com.joy.MOVIERESERVATIONSYSTEM.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReservationService {

    private final MemberRepository memberRepository;
    private final MovieRepository movieRepository;
    private final ReservationRepository reservationRepository;

    //예매
    @Transactional
    public Long reservation(Long memberId, Long movieId, int count) {

         //엔티티 조회
         Member member = memberRepository.findById(memberId).get();
         Movie movie = movieRepository.findById(movieId).get();


         //예매
        Reservation reservation = Reservation.createReservation(member, movie, count);

        //예매저장
        reservationRepository.save(reservation);

        return reservation.getId();

    }


    //예매 취소
    @Transactional
    public void cancelReservation(Long orderId) {


        //주문 엔티티 조회
        Reservation reservation = reservationRepository.findById(orderId).get();

        //주문 취소
        reservation.cancel();
    }

    //검색

}
