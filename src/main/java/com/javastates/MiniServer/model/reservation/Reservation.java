package com.javastates.MiniServer.model.reservation;

import lombok.*;
import java.util.Date;

@Setter
@Getter
public class Reservation {
    // 예약내역
    private String userName;
    private String movieName;
    private Date createDate;
    private int seat;

    @Override
    public String toString() {
        return "Reservation{" +
                "userName='" + userName + '\'' +
                ", movieName='" + movieName + '\'' +
                ", createDate=" + createDate +
                ", seat=" + seat +
                '}';
    }

    public Reservation(String userName, String movieName, Date createDate, int seat) {
        this.userName = userName;
        this.movieName = movieName;
        this.createDate = createDate;
        this.seat = seat;
    }
}
