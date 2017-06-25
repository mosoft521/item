package com.company.ch12Think.item146.section3;

public class Client {
    /*
      * 该算法不如某某算法优秀，可以优化，时间太紧，以后再说
      */
    public void doSomethong() {
    }
}

/**
 * 2010-09-16  张三   创建该问题，实现XX算法
 * 2010-10-28  李四   修正算法中的XXXX缺陷
 * 2010-11-30  李四   重构了XXX方法
 * 2011-02-06  王五   删除了XXXX无用方法
 * 2011-04-08  马六   优化了XXX的性能
 */
class Foo {
    /**
     * Attempt to acquire the lock for the given mutex. If the mutex has already
     * been acquired, the call returns immediately with APR_EBUSY. Note: it
     * is important that the APR_STATUS_IS_EBUSY(s) macro be used to determine
     * if the return value was APR_EBUSY, for portability reasons.
     *
     * @param mutex the mutex on which to attempt the lock acquiring.
     */
    public static native int trylock(long mutex);
}