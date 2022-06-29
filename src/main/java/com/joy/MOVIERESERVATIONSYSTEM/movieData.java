package com.joy.MOVIERESERVATIONSYSTEM;

import com.joy.MOVIERESERVATIONSYSTEM.domain.movie.Movie;
import com.joy.MOVIERESERVATIONSYSTEM.domain.movie.Region;
import com.joy.MOVIERESERVATIONSYSTEM.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class movieData {

    private final MovieRepository movieRepository;

    @PostConstruct
    public void init(){

        Movie movie=new Movie();
        movie.setTitle("탑건:매거릭");
        movie.setDirector("조셉 코신스키");
        movie.setMaxSeat(350);
        movie.setRemainSeat(350);
        movie.setDate("2022-07-03");
        movie.setTime("09:45");
        movie.setId(2L);
        movie.setCinemaNum(1);
        movie.setRegion(Region.BUSAN);
        movie.setPrice(10000);
        movieRepository.save(movie);

        Movie movie2=new Movie();
        movie2.setTitle("범죄도시2");
        movie2.setDirector("이상용");
        movie2.setMaxSeat(200);
        movie2.setRemainSeat(200);
        movie2.setDate("2022-07-06");
        movie2.setTime("16:30");
        movie2.setId(3L);
        movie2.setCinemaNum(5);
        movie2.setRegion(Region.SEOUL);
        movie2.setPrice(12000);
        movieRepository.save(movie2);

        Movie movie3=new Movie();
        movie3.setTitle("버즈 라이트이어");
        movie3.setDirector("앤거스 맥클레인");
        movie3.setMaxSeat(130);
        movie3.setRemainSeat(130);
        movie3.setDate("2022-07-04");
        movie3.setTime("12:00");
        movie3.setId(4L);
        movie3.setCinemaNum(2);
        movie3.setRegion(Region.JEJU);
        movie3.setPrice(12000);
        movieRepository.save(movie3);

        Movie movie4=new Movie();
        movie4.setTitle("쥬라기월드:도미니언");
        movie4.setDirector("콜린 트레보로우");
        movie4.setMaxSeat(230);
        movie4.setRemainSeat(230);
        movie4.setDate("2022-07-03");
        movie4.setTime("18:00");
        movie4.setId(5L);
        movie4.setCinemaNum(2);
        movie4.setRegion(Region.SEOUL);
        movie4.setPrice(12000);
        movieRepository.save(movie4);
    }
}
