package com.company.ch07GenericAndReflect.item108.section1;

public abstract class AbsPopulator {
    //模板方法
    public final void dataInitialing() throws Exception {
        //调用基本方法
        doInit();
    }

    //基本方法
    protected abstract void doInit();
}
