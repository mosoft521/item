package com.company.ch12Think.item150;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Client {
    public static void main(String[] args) {
        String[] str = "String".split("");
        // for(String s:str){
        // System.out.println(s);
        // }
        // System.out.println("String".split("").length);
        System.out.println(delString2("abcdefgab"));
    }

    public static String delString(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            boolean repeated = false;
            for (int j = 0; j < result.length(); j++) {
//                if (result.contains(str.charAt(i))
            }
            if (!repeated) {
                result += str.charAt(i);
            }
        }
        return result;
    }

    public static String delString2(String str) {
        String result = "";
        List<String> list = Arrays.asList(str.split(""));
        Set<String> set = new TreeSet<String>(list);
        for (String s : set) {
            result += s;
        }
        return result;
    }
}
