package com.company.ch04String.item057;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //接收键盘输入
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String str = input.nextLine();
            //使用split方法分隔后统计
            int wordsCount = str.split(" ").length;
            System.out.println(str + " 单词数：" + wordsCount);
        }
    }
}
