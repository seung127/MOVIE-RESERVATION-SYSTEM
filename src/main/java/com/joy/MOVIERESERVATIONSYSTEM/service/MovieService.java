package com.joy.MOVIERESERVATIONSYSTEM.service;

import com.joy.MOVIERESERVATIONSYSTEM.domain.movie.Movie;
import com.joy.MOVIERESERVATIONSYSTEM.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public void saveItem(Movie movie) {
        movieRepository.save(movie);
    }

    public List<Movie> findItems() {
        return movieRepository.findAll();
    }
    public Optional<Movie> findById(Long movieId) {
        return movieRepository.findById(movieId);
    }
}
