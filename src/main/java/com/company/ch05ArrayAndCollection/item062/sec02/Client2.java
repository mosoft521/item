package com.company.ch05ArrayAndCollection.item062.sec02;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 气球颜色
enum Color {
    Red, Orange, Yellow, Green, Indigo, Blue, Violet;
}

public class Client2 {
    public static void main(String[] args) {
        //气球数量
        int ballonNum = 7;
        // 第一个箱子
        List<Balloon> box1 = new ArrayList<Balloon>();
        // 初始化第一个箱子中的气球
        for (int i = 0; i < ballonNum; i++) {
            box1.add(new Balloon(Color.values()[i], i));
        }
        //转换为数组
        Balloon[] b1 = new Balloon[box1.size()];
        box1.toArray(b1);
        //数组在转换为List
        List<Balloon> box2 = Arrays.asList(b1);
        //修改气球原色
        box2.get(6).setColor(Color.Blue);
        //遍历第一个箱子的气球
        for (Balloon b : box1) {
            System.out.println(b);
        }
    }
}

// 气球
class Balloon {
    // 编号
    private int id;
    // 颜色
    private Color color;

    public Balloon(Color _color, int _id) {
        color = _color;
        id = _id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //apache-common包下的ToStringBuilder重写toString方法
    public String toString() {
        return new ToStringBuilder(this)
                .append("编号", id)
                .append("颜色", color)
                .toString();
    }
}
