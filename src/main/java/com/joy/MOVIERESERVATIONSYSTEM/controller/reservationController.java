package com.joy.MOVIERESERVATIONSYSTEM.controller;

import com.joy.MOVIERESERVATIONSYSTEM.controller.dto.ReservationSearch;
import com.joy.MOVIERESERVATIONSYSTEM.domain.member.Member;
import com.joy.MOVIERESERVATIONSYSTEM.domain.movie.Movie;
import com.joy.MOVIERESERVATIONSYSTEM.domain.reservation.Reservation;
import com.joy.MOVIERESERVATIONSYSTEM.service.MemberService;
import com.joy.MOVIERESERVATIONSYSTEM.service.MovieService;
import com.joy.MOVIERESERVATIONSYSTEM.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.persistence.criteria.Order;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class reservationController {

    private final ReservationService reservationService;
    private final MemberService memberService;
    private final MovieService movieService;

    @GetMapping(value = "/reservation")
    public String createForm(Model model) {

        List<Member> members = memberService.findMembers();
        List<Movie> movies = movieService.findMovies();

        model.addAttribute("members", members);
        model.addAttribute("movies", movies);

        return "reservation/reservationForm";
    }


    @PostMapping(value = "/reservation")
    public String order(@RequestParam("memberId") Long memberId,
                        @RequestParam("movieId") Long movieId, @RequestParam("count") int count) {
        reservationService.reservation(memberId, movieId, count);
        return "redirect:/reservations";
    }


    @GetMapping(value = "/reservations")
    public String reservationList(@ModelAttribute("reservationSearch") ReservationSearch reservationSearch, Model model) {
        List<Reservation> reservations = reservationService.findReservationsTitle(reservationSearch.getTitle());
        model.addAttribute("reservations", reservations);
        List<Movie> movies = movieService.findMovies();
        model.addAttribute("movies", movies);
        return "reservation/reservationList";
    }


    @PostMapping(value = "/reservations/{reservationId}/cancel")
    public String cancelReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.cancelReservation(reservationId);
        return "redirect:/reservations";
    }




}
