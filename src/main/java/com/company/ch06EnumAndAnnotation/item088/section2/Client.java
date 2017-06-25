package com.company.ch06EnumAndAnnotation.item088.section2;

enum CarFactory {
    //定义工厂类能生产汽车的类型
    FordCar, BuickCar;

    //生产汽车
    public Car create() {
        switch (this) {
            case FordCar:
                return new FordCar();
            case BuickCar:
                return new BuickCar();
            default:
                throw new AssertionError("无效参数");
        }
    }
}

interface Car {
}

public class Client {
    public static void main(String[] args) {
        //生产汽车
        Car car = CarFactory.BuickCar.create();
    }
}

class FordCar implements Car {
}

class BuickCar implements Car {
}