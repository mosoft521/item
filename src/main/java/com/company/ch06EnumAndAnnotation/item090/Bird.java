package com.company.ch06EnumAndAnnotation.item090;

// 鸟的抽象类
@Desc(c = Desc.Color.White)
abstract class Bird {
    // 鸟的颜色
    public abstract Desc.Color getColor();
}