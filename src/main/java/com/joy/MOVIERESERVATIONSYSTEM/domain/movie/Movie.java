package com.joy.MOVIERESERVATIONSYSTEM.domain.movie;

import com.joy.MOVIERESERVATIONSYSTEM.domain.reservation.Reservation;
import com.joy.MOVIERESERVATIONSYSTEM.exception.NotEnoughCinema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Movie {

    @Id
    @GeneratedValue
    @Column(name = "movie_id")
    private long id;

    private int maxSeat;

    private int remainSeat; //잔여좌석수

    private int price;

    private String title;

    private String director;

    private int cinemaNum;

    private String date;

    private String time;

    @Enumerated(EnumType.STRING)
    private Region region; //영화관

    @OneToMany(mappedBy = "movie")
    private List<Reservation> reservations = new ArrayList<>();



    //==비즈니스 로직==//

    public void cancel(int seat){
        this.remainSeat+=seat;
    }

    public void reservationSeat(int seat){
        int restSeat=this.remainSeat-seat;
        if(restSeat<0){
            throw new NotEnoughCinema("you can't reservation");
        }
        this.remainSeat=restSeat;
    }

}
