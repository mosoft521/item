package com.company.ch10PerformanceAndEfficiency.item132.section2;

public class Client {
    public void doSomething() {
        //异常信息
        String exceptionMsg = "为出现异常了，快来就救为！";
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            //转换为自定义的运行期异常
            throw new MyException(e, exceptionMsg);
        }
    }
}

class MyException extends RuntimeException {
    public MyException(Throwable e, String msg) {
    }
}
