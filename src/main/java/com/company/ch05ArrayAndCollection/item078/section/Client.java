package com.company.ch05ArrayAndCollection.item078.section;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
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
        // 放入40万键值对
        for (int i = 0; i < 40 * 10000; i++) {
            map.put("key" + i, "vlaue" + i);
        }
    }
}
