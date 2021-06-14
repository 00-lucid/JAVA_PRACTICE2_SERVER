package com.javastates.MiniServer.respository;

import com.javastates.MiniServer.model.member.Member;
import com.javastates.MiniServer.model.movie.Movie;
import com.javastates.MiniServer.model.reservation.Reservation;

import java.util.*;

public class ReservationMemoryRespository implements ReservationRespository{

    Map<UUID, Reservation> uuidReservationMap = new HashMap<>() {{
        for(int i = 0; i < 5; i++) {
            UUID id = UUID.randomUUID();
            System.out.println(id);
            put(id, new Reservation("name" + i, "어벤져스", new Date(), "A" + i));
        }
    }};

    @Override
    public void save(Reservation reservation) {
        uuidReservationMap.put(UUID.randomUUID(), reservation);
    }

    @Override
    public Reservation findReservationById(UUID uuid) {
        return uuidReservationMap.get(uuid);
    }

    @Override
    public ArrayList<Reservation> findAllReservation() {
        ArrayList<Reservation> reservationArrayList = new ArrayList<>();

        for (UUID key : uuidReservationMap.keySet()) {
            // key를 바탕으로 값을 받아와서 새로운 ArrayList에 넣는다.
            reservationArrayList.add(uuidReservationMap.get(key));
        }

        return reservationArrayList;
    }
}
