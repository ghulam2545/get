package com.ghulam.solid.code;


interface Vehicle {
    String getEngineName();
    int getSpeed();
    // ...
}

class Bike implements Vehicle {

    @Override
    public String getEngineName() {
        return "";
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}

class ElectricBike implements Vehicle {

    @Override
    public String getEngineName() {
        // electric bike don't have engine
        return "";
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}

/** ************************************************************ */

interface RegularVehicle {
    String getEngineName();
    int getSpeed();
}

interface ElectricVehicle {
    String getEngineName();
    int getSpeed();
}

class RBike implements RegularVehicle {

    @Override
    public String getEngineName() {
        return "";
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}

class EBike implements ElectricVehicle {

    @Override
    public String getEngineName() {
        return "";
    }

    @Override
    public int getSpeed() {
        return 0;
    }
}

public class InterfaceSegregation {
    public static void main(String[] args) {

    }
}
