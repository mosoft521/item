package com.company.ch05ArrayAndCollection.item078.section2;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        final Runtime rt = Runtime.getRuntime();
        // JVM终止前记录内存信息
        rt.addShutdownHook(new Thread() {
            @Override
            public void run() {
                StringBuffer sb = new StringBuffer();
                long heapMaxSize = rt.maxMemory() >> 20;
                sb.append("最大可用内存：" + heapMaxSize + "M\n");
                long total = rt.totalMemory() >> 20;
                sb.append("对内存大小：" + total + "M\n");
                long free = rt.freeMemory() >> 20;
                sb.append("空闲内存：" + free + "M");
                System.out.println(sb);
            }
        });
        // 放入40万同样字符串
        for (int i = 0; i < 502654; i++) {
            list.add("key" + i);
            list.add("vlaue" + i);
        }
    }
}
