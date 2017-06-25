package com.company.ch06EnumAndAnnotation.item090;

// 鸟巢，工厂方法模式
enum BirdNest {
    Sparrow;

    // 鸟类繁殖
    public Bird reproduce() {
        Desc bd = Sparrow.class.getAnnotation(Desc.class);
        return bd == null ? new Sparrow() : new Sparrow(bd.c());
    }
}