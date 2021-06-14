package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.reservation.Reservation;
import com.javastates.MiniServer.respository.ReservationMemoryRespository;
import com.javastates.MiniServer.respository.ReservationRespository;

import java.util.*;

public class ReservationServiceImpl implements ReservationService{

    ReservationRespository reservationRespository = new ReservationMemoryRespository();

    @Override
    public void join(Reservation reservation) {
        reservationRespository.save(reservation);
    }

    @Override
    public Reservation findById(UUID uuid) {
        return reservationRespository.findReservationById(uuid);
    }

    @Override
    public ArrayList<Reservation> findAllReservation() {
        return reservationRespository.findAllReservation();
    }
}
