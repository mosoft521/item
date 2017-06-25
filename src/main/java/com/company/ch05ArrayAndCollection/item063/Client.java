package com.company.ch05ArrayAndCollection.item063;
/**
 * 计算ArrayList和Vector的性能
 */

import java.util.List;
import java.util.Vector;

public class Client {
    public static void main(String[] args) {
        int max = 7000000;
        List<String> strs = new Vector<String>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            strs.add("a");
        }
        System.out.println(System.currentTimeMillis() - begin);
    }
}
