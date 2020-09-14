package com.huiyun;

public class Main {

    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox(6);
//        Gearbox.Gear first = mcLaren.new Gear(1,12.3);
//        Gearbox.Gear second = mcLaren.new Gear(2, 15.4);
//        System.out.println(first.driveSpeed(1000));
        mcLaren.addGear(1, 5.3);
        mcLaren.addGear(2, 10.2);
        mcLaren.addGear(3, 15.3);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);


    }
}
