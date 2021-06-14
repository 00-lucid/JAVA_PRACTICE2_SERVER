package com.javastates.MiniServer.model.reservation;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Reservation {
    // 예약내역
    private String userName;
    private String movieName;
    private Date createDate;
    private String seat;

    public Reservation(String userName, String movieName, Date createDate, String seat) {
        this.userName = userName;
        this.movieName = movieName;
        this.createDate = createDate;
        this.seat = seat;
    }
}
