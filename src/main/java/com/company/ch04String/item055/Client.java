package com.company.ch04String.item055;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        String str1 = 1 + 2 + " apples";
        String str2 = "apples:" + 1 + 2;
        @SuppressWarnings("unused")
        List list = new ArrayList();
        String str = str1 + new ArrayList();
        System.out.println(str);
        System.out.println(str2);
    }
}
