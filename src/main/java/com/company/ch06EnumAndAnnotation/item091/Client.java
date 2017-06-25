package com.company.ch06EnumAndAnnotation.item091;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//常用鉴权者
enum CommonIdentifier implements Identifier {
    //权限级别
    Reader, Author, Admin;

    //实现鉴权
    public boolean identify() {
        return false;
    }
}

//鉴权者接口
interface Identifier {
    //无权访问时的礼貌语
    String REFUSE_WORD = "您无权访问";

    // 鉴权
    public boolean identify();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Access {
    //确定什么级别可以访问
    CommonIdentifier level() default CommonIdentifier.Admin;
}

public class Client {
    public static void main(String[] args) {
        //初始化商业逻辑
        Foo b = new Foo();
        //获取注解
        Access access = b.getClass().getAnnotation(Access.class);
        //没有Access注解或者鉴权失败
        if (access == null || !access.level().identify()) {
            //没有Access注解或者鉴权失败
            System.out.println(access.level().REFUSE_WORD);
        }
    }
}

//商业逻辑，默认访问权限是Admin
@Access(level = CommonIdentifier.Author)
class Foo {
}
