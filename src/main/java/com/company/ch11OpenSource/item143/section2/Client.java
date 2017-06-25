package com.company.ch11OpenSource.item143.section2;

import gnu.trove.decorator.TIntListDecorator;
import gnu.trove.function.TIntFunction;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.procedure.TIntProcedure;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        // 基本类型的集合,不使用包装类型
        TIntList intList = new TIntArrayList();
        // 每个元素值乘以2
        intList.transformValues(new TIntFunction() {
            public int execute(int element) {
                return element * 2;
            }
        });
        // 过滤，把大于200的元素组成一个新的列表
        TIntList t2 = intList.grep(new TIntProcedure() {
            public boolean execute(int _element) {
                return _element > 200;
            }
        });
        // 包装为JDK的List
        List<Integer> list = new TIntListDecorator(intList);
        // 键类型确定Map
        TIntObjectMap<String> map = new TIntObjectHashMap<String>();
    }
}
