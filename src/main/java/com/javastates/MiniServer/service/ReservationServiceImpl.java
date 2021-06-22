package com.javastates.MiniServer.service;

import com.javastates.MiniServer.domain.reservation.Reservation;
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

    @Override
    public Stream<Integer> getArrMovieSeat(String movieName) {
            ArrayList<Reservation> reservationArrayList = reservationRespository.findMovieReservation(movieName);
            Stream<Integer> result = reservationArrayList.stream()
                    .map(reservation -> reservation.getSeat() - 1);
            return result;
    }
}
