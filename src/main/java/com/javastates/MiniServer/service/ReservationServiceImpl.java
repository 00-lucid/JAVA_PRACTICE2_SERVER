package com.javastates.MiniServer.service;

import com.javastates.MiniServer.model.reservation.Reservation;
import com.javastates.MiniServer.respository.ReservationRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRespository reservationRespository;

    @Override
    public void join(Reservation reservation) {
        try {
            reservationRespository.save(reservation);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public Reservation findById(UUID uuid) {
        try {
            return reservationRespository.findReservationById(uuid);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Reservation> findAllReservation() {
        try {
            return reservationRespository.findAllReservation();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Stream<Integer> getArrMovieSeat(String movieName) {
        try {
            ArrayList<Reservation> reservationArrayList = reservationRespository.findMovieReservation(movieName);
            Stream<Integer> result = reservationArrayList.stream()
                    .map(reservation -> reservation.getSeat() - 1);
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
