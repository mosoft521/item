package com.company.ch06EnumAndAnnotation.item090;

import com.company.ch06EnumAndAnnotation.item090.Desc.Color;

public class Client {
    // 模拟业务调用
    public static void main(String[] args) {
        Bird bird = BirdNest.Sparrow.reproduce();
        Color color = bird.getColor();
        System.out.println("Bird's color is: " + color);
    }
}
