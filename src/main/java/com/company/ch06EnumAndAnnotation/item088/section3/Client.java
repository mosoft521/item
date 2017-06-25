package com.company.ch06EnumAndAnnotation.item088.section3;

enum CarFactory {
    FordCar {
        public Car create() {
            return new FordCar();
        }
    },
    BuickCar {
        public Car create() {
            return new BuickCar();
        }
    };

    //抽象生产方法
    public abstract Car create();
}

interface Car {
};

public class Client {
    public static void main(String[] args) {
        Car car = CarFactory.BuickCar.create();
    }
};

class FordCar implements Car {
};

class BuickCar implements Car {
}