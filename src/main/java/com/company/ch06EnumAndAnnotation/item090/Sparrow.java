package com.company.ch06EnumAndAnnotation.item090;

// 麻雀
class Sparrow extends Bird {
    private Desc.Color color;

    // 默认是浅灰色
    public Sparrow() {
        color = Desc.Color.Grayish;
    }

    // 构造函数定义鸟的颜色
    public Sparrow(Desc.Color _color) {
        color = _color;
    }

    @Override
    public Desc.Color getColor() {
        return color;
    }
}