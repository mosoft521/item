package com.company.ch05ArrayAndCollection.item070.section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Client {
    public static void main(String[] args) {
//		String str = "AB";
//		String str1 = new String(str);
//		String str2 = str.substring(0) + "C";
//		System.out.println("str == str1? " + str1.equals(str1));
//		System.out.println("str == str2? " + str.equals(str2));
        List<String> strs = new ArrayList<String>();
        strs.add("A");
        List<String> strs2 = new Vector<String>();
        strs2.add("A");
        System.out.println(strs.equals(strs2));
    }
}
