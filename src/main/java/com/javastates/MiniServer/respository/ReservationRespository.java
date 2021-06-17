package com.javastates.MiniServer.respository;

import com.javastates.MiniServer.model.reservation.Reservation;

import java.util.*;

public interface ReservationRespository {
    void save(Reservation reservation);

    Reservation findReservationById(UUID uuid);

    ArrayList<Reservation> findAllReservation();

    ArrayList<Reservation> findMovieReservation(String movieName);
}
