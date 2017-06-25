package com.company.ch06EnumAndAnnotation.item087.section2;

import java.util.Arrays;
import java.util.List;

enum Season {
    Spring, Summer, Autumn, Winter;

    public boolean contains(String _name) {
        Season[] season = values();
        for (Season s : season) {
            if (s.name().equals(_name)) {
                return true;
            }
        }
        return false;
    }
}

public class Client {
    public static void main(String[] args) {
        //注意summer是小写
        List<String> params = Arrays.asList("Spring", "summer");
        for (String name : params) {
            //查找表面值与name相同的枚举项
            try {
                Season s = Season.valueOf(name);
                // 有该枚举项时的处理
                System.out.println(s);
            } catch (Exception e) {
                System.out.println("无相关枚举项");
            }
        }
    }
}
