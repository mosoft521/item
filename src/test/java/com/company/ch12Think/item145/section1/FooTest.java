package com.company.ch12Think.item145.section1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FooTest {
    //构建测试对象
    private Foo foo = new Foo();

    //正常测试场景
    @Test
    public void testDividNormal() {
        //断言100除以10的结果为10
        assertEquals(10, foo.divid(100, 10));
    }

    //边界测试场景
    @Test
    public void testDividBroader() {
        //断言最大值除以最小值结果为0
        assertEquals(0, foo.divid(Integer.MAX_VALUE, Integer.MIN_VALUE));
        //断言最小值除以最大值结果为-1
        assertEquals(-1, foo.divid(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    //异常测试场景
    @Test(expected = ArithmeticException.class)
    public void testDividException() {
        //断言除数为0时抛出ArithmeticException
        foo.divid(100, 0);
        //断言不会执行到这里
        fail();
    }
}
