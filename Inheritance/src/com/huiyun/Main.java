package com.huiyun;

public class Main {

    public static void main(String[] args) {
	    Animal animal = new Animal("Animal", 1, 1, 5, 5);
	    Dog dog = new Dog("Auggie", 8,20,2,4,1,20,"long silky");
	    dog.eat();
	    dog.walk();
	    dog.run();

	    Fish fish = new Fish("Amy", 10, 3, 2, 2, 2);
	    fish.eat();
	    fish.move(2);
	    fish.swim(3);
    }
}
