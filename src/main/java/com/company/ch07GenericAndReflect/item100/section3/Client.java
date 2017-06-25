package com.company.ch07GenericAndReflect.item100.section3;

public class Client<T> {
    public static void main(String[] args) {
        //objArray的实际类型和表面类型都是String数组
        Object[] objArray = {"A", "B"};
        //抛出ClassCastException
        String[] strArray = (String[]) objArray;
        String[] ss = {"A", "B"};
        //objs的真实类型是String数组，显示类型为Object数组
        Object[] objs = ss;
        //顺利转换为String数组
        String[] strs = (String[]) objs;
    }
}
