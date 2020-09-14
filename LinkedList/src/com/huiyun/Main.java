package com.huiyun;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");

        printList(placesToVisit);

        addInOrder(placesToVisit, "Alice Springs");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);


//        placesToVisit.add(1, "Alice Springs");
//        printList(placesToVisit);
//
//        placesToVisit.remove(4);
//        printList(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList) {
        // Loop linkedList by using iterator
        Iterator<String> str = linkedList.iterator();
        while(str.hasNext()) {
            System.out.println("Now visiting " + str.next());
        }
        System.out.println("================================");
    }

    private static void addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity); // 0 means match
            if (comparison == 0) {
                System.out.println(newCity + " is already included as a destination");
            } else if (comparison > 0) {
                // new City should appear before this one
                stringListIterator.previous(); // go back to previous entry
                stringListIterator.add(newCity);
            }
        }
        stringListIterator.add(newCity);
    }


}
