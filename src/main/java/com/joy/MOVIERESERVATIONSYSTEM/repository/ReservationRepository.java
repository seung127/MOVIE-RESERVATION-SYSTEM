package com.joy.MOVIERESERVATIONSYSTEM.repository;

import com.joy.MOVIERESERVATIONSYSTEM.domain.member.Member;
import com.joy.MOVIERESERVATIONSYSTEM.domain.movie.Movie;
import com.joy.MOVIERESERVATIONSYSTEM.domain.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("select r from Reservation r where r.movie.region = :region")
    List<Reservation> findByRegion(@Param("region") Enum region);

    @Query("select r from Reservation r where r.movie.title = :title")
    List<Reservation> findByTitle(@Param("title") String title);
}
