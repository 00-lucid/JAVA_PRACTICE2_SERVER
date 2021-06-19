package com.javastates.MiniServer.respository;

import com.javastates.MiniServer.model.member.Member;
import com.javastates.MiniServer.model.movie.Movie;
import com.javastates.MiniServer.model.reservation.Reservation;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ReservationMemoryRespository implements ReservationRespository{

    Map<UUID, Reservation> uuidReservationMap = new HashMap<>() {{
        for(int i = 0; i < 5; i++) {
            UUID id = UUID.randomUUID();
            System.out.println(id);
            put(id, new Reservation("name" + i, "어벤져스", new Date(), i));
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

    // 특정 영화의 예약정보([1, 2, 3])을 가져오는 함수가 필요하다.
    // 기존의 repo 메소드를 그대로 쓰면서 서비스에서 가공할 방법이 있을까? (비즈니스 로직 서비스 집중)
    // 그래도 최소한 특정 영화의 예약 배열을 가져오는 메소드는 필요할 것 같다

    @Override
    public ArrayList<Reservation> findMovieReservation(String movieName) {
        ArrayList<Reservation> reservationArrayList = new ArrayList<>();

        for (UUID key : uuidReservationMap.keySet()) {
            Reservation reservation = uuidReservationMap.get(key);
            if (reservation.getMovieName().equals(movieName)) {
                reservationArrayList.add(reservation);
            }
        }

        return reservationArrayList;
    }
}
