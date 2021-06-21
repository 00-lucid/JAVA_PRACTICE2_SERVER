package com.javastates.MiniServer.respository;

import com.javastates.MiniServer.domain.reservation.Reservation;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public interface ReservationRespository {
    void save(Reservation reservation);

    Reservation findReservationById(UUID uuid);

    ArrayList<Reservation> findAllReservation();

    ArrayList<Reservation> findMovieReservation(String movieName);
}
