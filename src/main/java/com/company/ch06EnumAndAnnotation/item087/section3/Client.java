package com.company.ch06EnumAndAnnotation.item087.section3;

import java.util.Arrays;
import java.util.List;

enum Season {
    Spring, Summer, Autumn, Winter;

    // 是否包含指定名称的枚举项
    public static boolean contains(String name) {
        // 所有的枚举值
        Season[] season = values();
        // 遍历查找
        for (Season s : season) {
            if (s.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class Client {
    public static void main(String[] args) {
        // 注意summer是小写
        List<String> params = Arrays.asList("Spring", "summer");
        for (String name : params) {
            // 查找表面值与name相同的枚举项
            Season s = Season.valueOf(name);
            if (s != null) {
                // 有该枚举项时的处理
                System.out.println(s);
            } else {
                // 没有该枚举项时的逻辑处理
                System.out.println("无相关枚举项");
            }
//			if (Season.contains(name)) {
//				Season s = Season.valueOf(name);
//				// 有该枚举项时的处理
//				System.out.println(s);
//			} else {
//
//				System.out.println("无相关枚举项");
//
//			}
        }
    }
}
