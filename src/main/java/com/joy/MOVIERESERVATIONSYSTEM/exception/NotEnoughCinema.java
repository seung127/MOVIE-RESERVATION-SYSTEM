package com.joy.MOVIERESERVATIONSYSTEM.exception;

public class NotEnoughCinema extends RuntimeException {

    public NotEnoughCinema() {
    }
    public NotEnoughCinema(String message) {
        super(message);
    }
    public NotEnoughCinema(String message, Throwable cause) {
        super(message, cause);
    }
    public NotEnoughCinema(Throwable cause) {
        super(cause);
    }
}
