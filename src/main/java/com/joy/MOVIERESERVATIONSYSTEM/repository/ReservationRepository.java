package com.joy.MOVIERESERVATIONSYSTEM.repository;

import com.joy.MOVIERESERVATIONSYSTEM.domain.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("select r from Reservation r where r.movie.title = :title")
    List<Reservation> findByTitle(@Param("title") String title);
}
