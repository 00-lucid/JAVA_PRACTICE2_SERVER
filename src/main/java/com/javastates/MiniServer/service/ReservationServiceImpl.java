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

    public ArrayList<Integer> getArrMovieSeat(String movieName) {
        ArrayList<Reservation> reservationArrayList = reservationRespository.findMovieReservation(movieName);
        ArrayList<Integer> resultArr = new ArrayList<>();
        // 생성하는 resultArr과 forEach 메소드를 이용하는 것이 아닌 stream + map으로 해결할 수 없을까?
        reservationArrayList.forEach(reservation -> resultArr.add(reservation.getSeat() - 1));

        return resultArr;
    }
}
