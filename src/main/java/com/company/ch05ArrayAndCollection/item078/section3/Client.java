package com.company.ch05ArrayAndCollection.item078.section3;

public class Client {
    public static void main(String[] args) {
        //Map的最后一次扩容
        int mapSize = 16;
        for (int i = 0; i < 100; i++) {
            mapSize = mapSize * 2;
            if (mapSize > 40 * 10000) {
                System.out.println(i);
                System.out.println("map的最后一次扩容：" + (mapSize * 3 / 4));
                return;
            }
        }
        int listSize = 10;
        for (int i = 1; i < 1000; i++) {
            listSize = (listSize * 3) / 2 + 1;
            if (listSize > 40 * 10000 * 2) {
                System.out.println("list的最后一次扩容:" + listSize);
                return;
            }
        }
    }
}
