package com.company.ch11OpenSource.item141.section4;

import org.apache.commons.lang3.time.StopWatch;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        Thread.sleep(100);
        sw.stop();
    }
}
