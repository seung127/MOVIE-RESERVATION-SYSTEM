package com.joy.MOVIERESERVATIONSYSTEM.repository;

import com.joy.MOVIERESERVATIONSYSTEM.domain.member.Member;
import com.joy.MOVIERESERVATIONSYSTEM.domain.movie.Movie;
import com.joy.MOVIERESERVATIONSYSTEM.domain.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m where m.region = :region")
    List<Movie> findByRegion(@Param("region") Enum region);

    @Query("select m from Movie m where m.title = :title")
    List<Movie> findByTitle(@Param("title") String title);



}
