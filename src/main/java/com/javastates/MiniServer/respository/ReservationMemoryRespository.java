package com.javastates.MiniServer.respository;

import com.javastates.MiniServer.domain.reservation.Reservation;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ReservationMemoryRespository implements ReservationRespository{

    Map<UUID, Reservation> uuidReservationMap = new HashMap<>();
    @Override
    public void save(Reservation reservation) {
        try {
            uuidReservationMap.put(UUID.randomUUID(), reservation);
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public Reservation findReservationById(UUID uuid) {
        try {
            return uuidReservationMap.get(uuid);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Reservation> findAllReservation() {
        try {
            ArrayList<Reservation> reservationArrayList = new ArrayList<>();

            for (UUID key : uuidReservationMap.keySet()) {
                reservationArrayList.add(uuidReservationMap.get(key));
            }

            return reservationArrayList;
        } catch (Exception e) {
            return null;
        }
    }

    // 특정 영화의 예약정보([1, 2, 3])을 가져오는 함수가 필요하다.
    // 기존의 repo 메소드를 그대로 쓰면서 서비스에서 가공할 방법이 있을까? (비즈니스 로직 서비스 집중)
    // 그래도 최소한 특정 영화의 예약 배열을 가져오는 메소드는 필요할 것 같다

    @Override
    public ArrayList<Reservation> findMovieReservation(String movieName) {
        try {
            ArrayList<Reservation> reservationArrayList = new ArrayList<>();

            for (UUID key : uuidReservationMap.keySet()) {
                Reservation reservation = uuidReservationMap.get(key);
                if (reservation.getMovieName().equals(movieName)) {
                    reservationArrayList.add(reservation);
                }
            }

            return reservationArrayList;
        } catch (Exception e) {
            return null;
        }
    }
}
