package com.huiyun;

public class Main {

    public static void main(String[] args) {
	    Hamburger burger = new Hamburger("Basic", "Sausage", 3.45, "White");
	    double price = burger.itemizeHamburger();
	    burger.addHamburgerAddition1("Tomato", 0.25);
        burger.addHamburgerAddition2("Lettuce", 0.5);
        burger.addHamburgerAddition3("Cheese", 1.55);
        System.out.println("Total burger price is : " + burger.itemizeHamburger());

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.78);
        healthyBurger.addHamburgerAddition1("Egg", 2.0);
        healthyBurger.addHealthAddition1("Lentils", 4.58);
        System.out.println("Total healthy burger price is : " + healthyBurger.itemizeHamburger());

        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.itemizeHamburger();
        deluxeBurger.addHamburgerAddition1("Egg", 2.0);
    }
}
