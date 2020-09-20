package com.huiyun;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	    Theatre theatre = new Theatre("Star", 10, 12);

        if (theatre.reserveSeat("A02")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Seat already reserved");
        }

        if (theatre.reserveSeat("E06")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Seat already reserved");
        }

        List<Theatre.Seat> reverseSeat = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeat);
        printList(reverseSeat);

        List<Theatre.Seat> priceSeat = new ArrayList<>(theatre.getSeats());
        priceSeat.add(theatre.new Seat("B00", 13.00));
        priceSeat.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeat, Theatre.PRICE_ORDER);
        printList(priceSeat);
    }

    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("===========================================");
    }


}
