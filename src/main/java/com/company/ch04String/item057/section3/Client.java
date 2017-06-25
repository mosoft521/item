package com.company.ch04String.item057.section3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    public static void main(String[] args) {
        //接收键盘输入
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String str = input.nextLine();
            //正则表达式对象
            Pattern pattern = Pattern.compile("\\b");
            //生成匹配器
            Matcher matcher = pattern.matcher(str);
            //记录单词数量
            int wordsCount = 0;
            //遍历查找匹配，统计单词数量
            while (matcher.find()) {
                System.out.println(matcher.group());
                wordsCount++;
            }
            System.out.println(str + " 单词数：" + wordsCount);
        }
    }
}
