package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Alvin
 * Date: 12-4-25
 * Time: 下午9:06
 */
public class OOMObjectTest {
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
//        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
        System.gc();
    }

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }
}
