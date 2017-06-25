package com.company.ch07GenericAndReflect.item105;

import java.lang.reflect.Array;

public class Client {
    public static void main(String[] args) throws Exception {
//		Integer[] strs = new Integer[10];
//		long[] bytes = new long[100];
//		System.out.println(strs.getClass());
//		//加载一个String数组
        Class.forName("[Ljava.lang.String;");
        //加载一个long数组
        Class.forName("[J");
        //数组反射了
        String[] strs = (String[]) Array.newInstance(String.class, 8);
        //创建一个多维数组
        int[][] ints = (int[][]) Array.newInstance(int.class, 2, 3);
    }
}
