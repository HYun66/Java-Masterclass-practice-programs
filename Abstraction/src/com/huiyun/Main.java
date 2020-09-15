package com.huiyun;

public class Main {

    public static void main(String[] args) {
	    Dog dog = new Dog("Auggie");
	    dog.breathe();
	    dog.eat();

//	    Bird bird = new Bird("Amy");
//	    bird.breathe();
//	    bird.eat();

		Parrot parrot = new Parrot("ringneck");
		parrot.breathe();
		parrot.eat();
		parrot.fly();

		Penguin penguin = new Penguin("Emperor");
		penguin.breathe();
		penguin.eat();
		penguin.fly();
    }
}
