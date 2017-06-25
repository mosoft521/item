package com.company.ch11OpenSource.item140.section6;

import com.google.common.base.Joiner;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        //定义连接符号
        Joiner joiner = Joiner.on("，");
        //可以连接多个对象，不局限于String;如果有null，则跳过
        String str = joiner.skipNulls().join("嘿", "Guava很不错的。");
        System.out.println(str);
        Map<String, String> map = new HashMap<String, String>();
        map.put("张三", "普通员工");
        map.put("李四", "领导");
        System.out.println("普通输出：" + map);
        //键值之间以"是”连接，多个键值以空格分隔
        System.out.println(Joiner.on("\r\n").withKeyValueSeparator(" 是 ").join(map));
    }
}
