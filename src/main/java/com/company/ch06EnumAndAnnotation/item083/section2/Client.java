package com.company.ch06EnumAndAnnotation.item083.section2;

interface Season {
    int Spring = 0;
    int Summer = 1;
    int Autumn = 2;
    int Winter = 3;
}

public class Client {
    public static void main(String[] args) {
        int season = Season.Summer;
        switch (season) {
            case Season.Summer:
                System.out.println("Summer is very hot!");
                break;
            case Season.Winter:
                System.out.println("Winter is very cold!");
                break;
            default:
                break;
        }
    }

    public void describe(int s) {
        //s变量不能超越边界
        if (s > -1 && s < 4) {
            switch (s) {
                case Season.Summer:
                    System.out.println("Summer is very hot!");
                    break;
                case Season.Winter:
                    System.out.println("Winter is very cold!");
                    break;
            }
        }
    }
}
