package com.company.ch10PerformanceAndEfficiency.item132.section1;

public class Client {
    public static void main(String[] args) {
        System.out.println(toChineseNum(0));
    }

    public static String toChineseNum(int num) {
        //中文数字
        String[] cns = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        return cns[num];
    }
}
