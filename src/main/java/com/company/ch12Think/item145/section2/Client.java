package com.company.ch12Think.item145.section2;

public class Client {
    public static void main(String[] args) {
        final Apple apple = new Apple();
        new Thread(new Runnable() {
            @Override
            public void run() {
                apple.setColor(100);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":"
                        + apple.getColor());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                apple.setColor(200);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":"
                        + apple.getColor());
            }
        }).start();
    }
}

class Apple {
    // 苹果颜色
    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
