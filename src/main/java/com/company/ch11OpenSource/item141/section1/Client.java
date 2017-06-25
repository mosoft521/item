package com.company.ch11OpenSource.item141.section1;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class Client {
    public static void main(String[] args) {
        String str = "ABCDA";
        // 判断一个字符串是否为空，null或""都返回true
        StringUtils.isEmpty(str);
        // 是否是数字
        StringUtils.isNumeric(str);
        // 最左边两个字符
        System.out.println(StringUtils.left(str, 2));
        // 统计子字符串出现的次数
        System.out.println(StringUtils.countMatches(str, "A"));
        // 转义XML标示
        System.out.println(StringEscapeUtils.escapeXml(str));
        // 随机生成，长度为10的仅字母的字符串
        System.out.println(RandomStringUtils.randomAlphabetic(10));
        //随机生成，长度为10的ASCII字符串
        System.out.println(RandomStringUtils.randomAscii(10));
        //以一个单词为操作对象，首字母大写，输出结果为:Abc Bcd
        System.out.println(WordUtils.capitalize("abc bcd"));
    }
}