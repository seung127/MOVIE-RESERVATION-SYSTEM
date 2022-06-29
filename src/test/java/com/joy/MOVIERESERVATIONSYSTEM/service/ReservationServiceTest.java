package com.joy.MOVIERESERVATIONSYSTEM.service;

import com.joy.MOVIERESERVATIONSYSTEM.domain.member.Member;
import com.joy.MOVIERESERVATIONSYSTEM.domain.movie.Movie;
import com.joy.MOVIERESERVATIONSYSTEM.domain.movie.Region;
import com.joy.MOVIERESERVATIONSYSTEM.domain.reservation.Reservation;
import com.joy.MOVIERESERVATIONSYSTEM.domain.reservation.ReservationStatus;
import com.joy.MOVIERESERVATIONSYSTEM.repository.ReservationRepository;
import org.assertj.core.api.Assertions;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;




@SpringBootTest
@Transactional
class ReservationServiceTest {

    @PersistenceContext
    EntityManager em;
    @Autowired
    ReservationService reservationService;

    @Autowired
    ReservationRepository reservationRepository;

    @Test
    public void 상품주문() throws Exception {
        //Given
        Member member = new Member();
        member.setName("회원1");
        Movie movie= new Movie();
        movie.setMaxSeat(10);
        movie.setRemainSeat(10);

        int count=2;

        em.persist(member);
        em.persist(movie);

        //When
        Long orderId = reservationService.reservation(member.getId(), movie.getId(), count);


        //Then
        Reservation getReservation = reservationRepository.findById(orderId).get();


        Assertions.assertThat(ReservationStatus.RESERVATION).isEqualTo(getReservation.getStatus());
        Assertions.assertThat(8).isEqualTo( movie.getRemainSeat());

    }

    @Test
    public void 주문취소() {

        //Given
        Member member = new Member();
        member.setName("회원1");
        Movie movie= new Movie();
        movie.setMaxSeat(10);
        movie.setRemainSeat(10);

        int count=2;

        em.persist(member);
        em.persist(movie);

        Long reservatedId = reservationService.reservation(member.getId(), movie.getId(), count);

        //When
        reservationService.cancelReservation(reservatedId);

        //Then

        Reservation getReservation = reservationRepository.findById(reservatedId).get();
        Assertions.assertThat(ReservationStatus.CANCEL).isEqualTo(getReservation.getStatus());
        Assertions.assertThat(movie.getRemainSeat()).isEqualTo(10);
    }

}