package com.huiyun;

class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.engine = true;
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine() {
        return "Car -> startEngine";
    }

    public String accelerate() {
        return "Car -> accelerate";
    }

    public String brake() {
        return "Car -> brake";
    }
}

class Mistubushi extends Car {
    public Mistubushi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Mistubushi -> startEngine";
    }

    @Override
    public String accelerate() {
        return "Mistubushi -> accelerate";
    }

    @Override
    public String brake() {
        return "Mistubushi -> brake";
    }
}

public class Main {

    public static void main(String[] args) {
	    Car car = new Car(8, "Base car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mistubushi mis = new Mistubushi(6, "VRW");
        System.out.println(mis.startEngine());
        System.out.println(mis.accelerate());
        System.out.println(mis.brake());

        // creating inline class
        Car ford = new Car(6, "falcon") {
            @Override
            public String startEngine() {
                return "Ford -> startEngine";
            }

            @Override
            public String accelerate() {
                return "Ford -> accelerate";
            }

            @Override
            public String brake() {
                return "Ford -> brake";
            }
        };
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        Holden holden = new Holden(6, "command");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());
    }

    static class Holden extends Car {
        public Holden(int cylinders, String name) {
            super(cylinders, name);
        }

        @Override
        public String startEngine() {
            return getClass().getSimpleName() + " -> startEngine";
        }

        @Override
        public String accelerate() {
            return getClass().getSimpleName() + " -> accelerate";
        }

        @Override
        public String brake() {
            return getClass().getSimpleName() + " -> brake";
        }
    }
}
