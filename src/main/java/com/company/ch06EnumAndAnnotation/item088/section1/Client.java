package com.company.ch06EnumAndAnnotation.item088.section1;

//抽象产品
interface Car {
}

public class Client {
    public static void main(String[] args) {
        //生产车辆
        Car car = CarFactory.createCar(Car.class);
    }
};

//具体产品类
class FordCar implements Car {
};

//具体产品类
class BuickCar implements Car {
};

//工厂类
class CarFactory {
    //生产汽车
    public static Car createCar(Class<? extends Car> c) {
        try {
            return (Car) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
