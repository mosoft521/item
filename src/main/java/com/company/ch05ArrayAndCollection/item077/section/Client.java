package com.company.ch05ArrayAndCollection.item077.section;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        int tagCloudNum = 10;
        List<String> tagClouds = new ArrayList<String>(tagCloudNum);
        //初始化标签云，一般是从数据库读入
        for (int i = 0; i < tagCloudNum; i++) {
            tagClouds.add("标签" + i);
        }
        //打乱顺序
        Random rand = new Random();
        for (int i = 0; i < tagCloudNum; i++) {
            //取得随机位置
            int randomPosition = rand.nextInt(tagCloudNum);
            //当前元素与随机元素交换
            String temp = tagClouds.get(i);
            tagClouds.set(i, tagClouds.get(randomPosition));
            tagClouds.set(randomPosition, temp);
        }
        //输出
        for (String tag : tagClouds) {
            System.out.println(tag);
        }
    }
}
