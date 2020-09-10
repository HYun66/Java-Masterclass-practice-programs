package com.huiyun;

public class Main {

    public static void main(String[] args) {
        // Without encapsulation
        Player player = new Player();
        player.name = "Sallie";
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        damage = 15;
        player.health = 200;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        // With encapsulation
        // Protect the members and methods of the class from external access
        // Make sure valid initialization
        EnhancedPlayer player1 = new EnhancedPlayer("Amy", 200, "Sword");
        System.out.println("Initial health is " + player1.getHealth());
    }
}
