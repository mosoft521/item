package com.company.ch07GenericAndReflect.item107;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

// 定义动物
interface Animal {
    public void doStuff();
}

// 定义某种能力
interface Feature {
    // 加载特性
    public void load();
}

public class Client {
    public static void main(String[] args) throws Exception {
        //定义Jerry这只家喻户晓的老鼠
        Animal Jerry = new Rat();
        //为Jerry增加飞行能力
        Jerry = new DecorateAnimal(Jerry, FlyFeature.class);
        //Jerry增加挖掘能力
        Jerry = new DecorateAnimal(Jerry, DigFeature.class);
        //Jerry开始耍猫了
        Jerry.doStuff();
    }
}

// 老鼠是一种动物
class Rat implements Animal {
    public void doStuff() {
        System.out.println("Jerry will play with Tom.");
    }
}

// 飞行能力
class FlyFeature implements Feature {
    public void load() {
        System.out.println("增加一只翅膀……");
    }
}

// 挖掘能力
class DigFeature implements Feature {
    public void load() {
        System.out.println("增加挖掘能力……");
    }
}

// 动物的包装类，可以包装所有的动物
class DecorateAnimal implements Animal {
    // 被包装的动物
    private Animal animal;
    // 使用哪一个包装器
    private Class<? extends Feature> clz;

    public DecorateAnimal(Animal _animal, Class<? extends Feature> _clz) {
        animal = _animal;
        clz = _clz;
    }

    @Override
    public void doStuff() {
        InvocationHandler handler = new InvocationHandler() {
            // 具体包装行为
            public Object invoke(Object p, Method m, Object[] args) throws Throwable {
                Object obj = null;
                //设置包装条件，例如根据ReturnType、Modifier等
                if (Modifier.isPublic(m.getModifiers())) {
                    obj = m.invoke(clz.newInstance(), args);
                }
                animal.doStuff();
                return obj;
            }
        };
        // 当前加载器
        ClassLoader cl = getClass().getClassLoader();
        // 动态代理，由Handler决定如何包装
        Feature proxy = (Feature) Proxy.newProxyInstance(cl, clz
                .getInterfaces(), handler);
        proxy.load();
    }
}