package com.company.ch06EnumAndAnnotation.item083.section4;

enum Season {
    Spring, Summer, Autumn, Winter;

    //最舒服的季节
    public static Season getComfortableSeason() {
        return Spring;
    }
}

public class Client {
    public static void main(String[] args) {
        System.out.println("The most comfortable season is " + Season.getComfortableSeason());
        System.out.println("The most comfortable season is " + Season.getComfortableSeason());
    }
}
