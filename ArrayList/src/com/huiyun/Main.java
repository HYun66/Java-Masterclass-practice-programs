package com.huiyun;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
            }

        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\n 0 - To print choice options. ");
        System.out.println("\n 1 - To print the list of grocery items. ");
        System.out.println("\n 2 - To add an item to the list. ");
        System.out.println("\n 3 - To modify an item in the list. ");
        System.out.println("\n 4 - To remove an item in the list. ");
        System.out.println("\n 5 - To search for an item in the list. ");
        System.out.println("\n 6 - To quit the application. ");
    }

    public static void addItem() {
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.println("Enter item name: ");
        String item = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(item, newItem);
    }

    public static void removeItem() {
        System.out.println("Enter item name: ");
        String item = scanner.nextLine();
        scanner.nextLine();
        groceryList.removeGroceryItem(item);
    }

    public static void searchForItem() {
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine();
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in the grocery list.");
        } else {
            System.out.println(searchItem + " not found in the grocery list.");
        }
    }

    public static void processArrayList() {
        // Copy ArrayList
        ArrayList<String> newArray = new ArrayList<>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<>(groceryList.getGroceryList());

        // ArrayList to Array
        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}
