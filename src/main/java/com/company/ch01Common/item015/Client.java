package com.company.ch01Common.item015;

/**
 * 养成良好习惯，break不可忘记
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("2 = " + toChineseNumberCase(2));
        System.out.println("0 = " + toChineseNumberCase(0));
    }

    //把阿拉伯数字翻译成中文大写数字
    public static String toChineseNumberCase(int n) {
        String chineseNumber = "";
        switch (n) {
            case 0:
                chineseNumber = "零";
                break;
            case 1:
                chineseNumber = "壹";
            case 2:
                chineseNumber = "贰";
            case 3:
                chineseNumber = "叁";
            case 4:
                chineseNumber = "肆";
            case 5:
                chineseNumber = "伍";
            case 6:
                chineseNumber = "陆";
            case 7:
                chineseNumber = "柒";
            case 8:
                chineseNumber = "捌";
            case 9:
                chineseNumber = "玖";
        }
        return chineseNumber;
    }
}
