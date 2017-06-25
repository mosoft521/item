package com.company.ch04String.item056;

public class Client {
    public static final int MAX_LOOP = 50000;

    public static void main(String[] args) {
//		doWithPlus();
//		doWithConcat();
//		doWithStringBuffer();
        String str = "abc";
        String str1 = str.concat("1");
        String str2 = "abc1";
        System.out.println(str1 == str2);
    }

    public static void doWithPlus() {
        String str = "a";
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_LOOP; i++) {
            str += "c";
            //str = new StringBuilder(prefix).append("c").toString();
        }
        long finish = System.currentTimeMillis();
        System.out.println("doWithPlus:" + (finish - start) + "ms");
    }

    public static void doWithConcat() {
        String str = "a";
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_LOOP; i++) {
            str = str.concat("c");
        }
        long finish = System.currentTimeMillis();
        System.out.println("doWithConcat:" + (finish - start) + "ms");
    }

    public static void doWithStringBuffer() {
        StringBuilder sb = new StringBuilder("a");
        long start = System.currentTimeMillis();
        for (int i = 0; i < MAX_LOOP; i++) {
            sb.append("c");
        }
        String str = sb.toString();
        long finish = System.currentTimeMillis();
        System.out.println("doWithStringBuffer:" + (finish - start) + "ms");
    }
}
