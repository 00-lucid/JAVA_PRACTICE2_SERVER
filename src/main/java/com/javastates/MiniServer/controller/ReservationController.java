package com.javastates.MiniServer.controller;

import com.javastates.MiniServer.model.reservation.Reservation;
import com.javastates.MiniServer.service.ReservationService;
import com.javastates.MiniServer.service.ReservationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@Controller
@ResponseBody
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReservationController {

    ReservationService reservationService = new ReservationServiceImpl();

    @GetMapping(value = "/reservation")
    private Reservation getReservation(@RequestParam UUID uuid) {
        return reservationService.findById(uuid);
    }

    @GetMapping(value = "/reservations")
    private ArrayList<Reservation> getReservations() {
        return reservationService.findAllReservation();
    }

    @PostMapping(value = "/reservation")
    private void addReservation(@RequestBody Reservation reservation) {
        System.out.println("여기여기여기여기여기여기여기여기여기여기" + reservation.toString());
        reservationService.join(reservation);
    }

    @GetMapping(value = "/reservation/seat")
    private ArrayList<Integer> getMovieReservationSeat(@RequestParam String movieName) {
        return reservationService.getArrMovieSeat(movieName);
    }
}
