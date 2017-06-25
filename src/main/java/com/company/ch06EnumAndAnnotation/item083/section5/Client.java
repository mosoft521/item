package com.company.ch06EnumAndAnnotation.item083.section5;

public class Client {
    public static void main(String[] args) {
    }
}

class Season {
    public final static int Spring = 0;
    public final static int Summer = 1;
    public final static int Autumn = 2;
    public final static int Winter = 3;

    public static int getComfortableSeason() {
        return Spring;
    }
}
