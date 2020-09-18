package com.huiyun;

public class Main {

    public static void main(String[] args) {
	    Theatre theatre = new Theatre("Star", 10, 12);
	    theatre.getSeats();

	    if (theatre.reserveSeat("E07")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        if (theatre.reserveSeat("A07")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
    }
}
