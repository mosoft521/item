package com.company.ch05ArrayAndCollection.item077.section3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        int tagCloudNum = 10;
        List<String> tagClouds = new ArrayList<String>(tagCloudNum);
        //初始化标签云，一般是从数据库读入
        for (int i = 0; i < tagCloudNum; i++) {
            tagClouds.add("标签" + i);
        }
        //打乱顺序
        Collections.shuffle(tagClouds);
        for (String tag : tagClouds) {
            System.out.println(tag);
        }
    }
}
