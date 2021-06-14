package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.reservation.Reservation;

import java.util.*;

public interface ReservationService {
    void join(Reservation reservation);

    Reservation findById(UUID uuid);

    ArrayList<Reservation> findAllReservation();
}
