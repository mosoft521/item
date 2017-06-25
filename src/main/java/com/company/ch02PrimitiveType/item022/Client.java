package com.company.ch02PrimitiveType.item022;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Client {
    public static void main(String[] args) {
        System.out.println(10.00 - 9.60);
//
        NumberFormat f = new DecimalFormat("#.##");
        System.out.println(f.format(10.00 - 9.60));
    }
}