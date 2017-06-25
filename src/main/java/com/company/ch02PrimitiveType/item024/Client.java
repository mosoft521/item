package com.company.ch02PrimitiveType.item024;

import java.util.Scanner;

public class Client {
    //一个会员拥有产品的最大数量
    public final static int LIMIT = 2000;

    public static void main(String[] args) {
        //会员当前拥有产品数量
        int cur = 1000;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入需要预定的数量：");
        while (input.hasNextInt()) {
            int order = input.nextInt();
            //当前拥有的与准备订购的产品数量之
            if (order > 0 && order + cur <= LIMIT) {
                System.out.println("你已经成功预定的" + order + "个产品！");
                cur += order;
            } else {
                System.out.println("超过限额，预订失败！");
            }
        }
    }
}
// 800
// 2147483647
