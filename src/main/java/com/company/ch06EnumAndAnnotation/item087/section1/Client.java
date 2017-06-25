package com.company.ch06EnumAndAnnotation.item087.section1;

import java.util.Arrays;
import java.util.List;

enum Season {
    Spring, Summer, Autumn, Winter;
}

public class Client {
    public static void main(String[] args) {
        //注意summer是小写
        List<String> params = Arrays.asList("Spring", "summer");
        for (String name : params) {
            //查找表面值与name相同的枚举项
            Season s = Season.valueOf(name);
            if (s != null) {
                // 有该枚举项时的处理
                System.out.println(s);
            } else {
                // 没有该枚举项时的逻辑处理
                System.out.println("无相关枚举项");
            }
        }
    }
}
