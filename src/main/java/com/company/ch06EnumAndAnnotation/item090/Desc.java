package com.company.ch06EnumAndAnnotation.item090;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@interface Desc {
    // 默认颜色是白色的
    Color c() default Color.White;

    enum Color {
        White, Grayish, Yellow;
    }
}