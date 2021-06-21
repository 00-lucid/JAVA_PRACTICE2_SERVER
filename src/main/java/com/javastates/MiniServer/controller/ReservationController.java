package com.javastates.MiniServer.controller;

import com.javastates.MiniServer.domain.reservation.Reservation;
import com.javastates.MiniServer.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Stream;

@Controller
@ResponseBody
@CrossOrigin(origins = "*", maxAge = 3600)
@Component
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping(value = "/reservation")
    private Reservation getReservation(@RequestParam UUID uuid) {
        try {
            return reservationService.findById(uuid);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "/reservations")
    private ArrayList<Reservation> getReservations() {
        try {
            return reservationService.findAllReservation();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(value = "/reservation")
    private void addReservation(@RequestBody Reservation reservation) {
        try {
            reservationService.join(reservation);
        } catch (Exception e) {
            return;
        }
    }

    @GetMapping(value = "/reservation/seat")
    private Stream<Integer> getMovieReservationSeat(@RequestParam String movieName) {
        try {
            return reservationService.getArrMovieSeat(movieName);
        } catch (Exception e) {
            return null;
        }
    }
}
