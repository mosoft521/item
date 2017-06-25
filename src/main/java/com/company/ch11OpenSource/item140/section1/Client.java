package com.company.ch11OpenSource.item140.section1;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        //不可变集合
        List<String> list = ImmutableList.of("A", "B", "C");
        //不可变Map
        Map<Integer, String> map = ImmutableMap.of(1, "壹", 2, "贰", 3, "叁");
    }
}
