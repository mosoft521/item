package com.company.ch07GenericAndReflect.item108.section2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class AbsPopulator {
    // 模板方法
    public final void dataInitialing() throws Exception {
        // 获得所有的public方法
        Method[] methods = getClass().getMethods();
        for (Method m : methods) {
            // 判断是否是数据初始化方法
            if (isInitDataMethod(m)) {
                m.invoke(this);
            }
        }
    }

    // 判断是否是数据初始化方法，基本方法鉴别器
    private boolean isInitDataMethod(Method m) {
        return m.getName().startsWith("init") // init开始
                && Modifier.isPublic(m.getModifiers()) // 公开方法
                && m.getReturnType().equals(Void.TYPE) // 返回值是void
                && !m.isVarArgs() // 输入参数为空
                && !Modifier.isAbstract(m.getModifiers()); // 不能是抽象方法
    }
}
