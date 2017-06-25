package com.company.ch06EnumAndAnnotation.item085;

enum Season {
    Spring, Summer, Autumn, Winter;
}

public class Client {
    public static void main(String[] args) {
        doSports(null);
    }

    public static void doSports(Season season) {
        switch (season) {
            case Spring:
                System.out.println("春天放风筝");
                break;
            case Summer:
                System.out.println("夏天游泳");
                break;
            case Autumn:
                System.out.println("秋天捉知了");
                break;
            case Winter:
                System.out.println("冬天滑冰");
                break;
            default:
                System.out.println("输入错误！");
                break;
        }
    }
}
