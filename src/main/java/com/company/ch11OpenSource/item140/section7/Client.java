package com.company.ch11OpenSource.item140.section7;

import com.google.common.base.Splitter;

public class Client {
    public static void main(String[] args) {
        String str = "你好，Guava";
        // 以"，"中文逗号分隔
        for (String s : Splitter.on("，").split(str)) {
            System.out.println(s);
        }
        // 按照固定长度分隔
        for (String s : Splitter.fixedLength(2).split(str)) {
            System.out.println(s);
        }
    }
}
