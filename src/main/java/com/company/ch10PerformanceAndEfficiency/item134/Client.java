package com.company.ch10PerformanceAndEfficiency.item134;

public class Client {
    public static void main(String[] args) {
        int i = 100 << 4;
        System.out.println(i * 800);
        System.out.println(i);
    }

}
