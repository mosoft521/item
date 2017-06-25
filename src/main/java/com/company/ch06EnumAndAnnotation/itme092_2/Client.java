package com.company.ch06EnumAndAnnotation.itme092_2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnno {
    MyAnno2 desc();
}

@interface MyAnno2 {
    String a() default "";
}

public class Client {
    public static void main(String[] args) {
        MyAnno an1 = Foo.class.getAnnotation(MyAnno.class);
        MyAnno an2 = Impl.class.getAnnotation(MyAnno.class);
        System.out.println(an1.hashCode());
        System.out.println(an2.hashCode());
        System.out.println(an1.equals(an2));
        System.out.println(an1 == an2);
    }
}

@MyAnno(desc = @MyAnno2(a = "a1a"))
class Foo {
    public void doSomething() {
    }
}

@MyAnno(desc = @MyAnno2(a = "aa"))
class Impl {
    public void doSomething() {
    }
}
