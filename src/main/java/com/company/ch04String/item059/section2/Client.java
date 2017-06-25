package com.company.ch04String.item059.section2;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Client {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        String[] strs = {"张三(Z)", "李四(L)", "王五(W)"};
        //定义一个中文排序器
        Comparator c = Collator.getInstance(Locale.CHINA);
        //升序排列
        Arrays.sort(strs, c);
        int i = 0;
        for (String str : strs) {
            System.out.println((++i) + "、" + str);
        }
    }
}
