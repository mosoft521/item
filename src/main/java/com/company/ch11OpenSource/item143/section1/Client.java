package com.company.ch11OpenSource.item143.section1;

import it.unimi.dsi.fastutil.BigList;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.ObjectBigArrayBigList;

public class Client {
    public static void main(String[] args) {
        // 超大容量的List，注意调整JVM的Heap内存
        BigList<Integer> bigList = new ObjectBigArrayBigList<Integer>(
                1L + Integer.MAX_VALUE);
        // 基本类型的集合,不再使用包装类型
        IntArrayList arrayList = new IntArrayList();
        // 明确键类型的Map
        Int2ObjectMap<String> map = new Int2ObjectOpenHashMap<String>();
        map.put(100, "A");
        System.out.println(map.get(100));
    }
}
