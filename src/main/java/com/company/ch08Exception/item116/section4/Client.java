package com.company.ch08Exception.item116.section4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Client {
    public static void main(String[] args) {
        File file = new File("文件.txt");
        //经常出现的异常情况，可以先做判断
        if (file.exists() && !file.isDirectory()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                /* 其他业务逻辑处理 */
            } catch (FileNotFoundException e) {
                // 异常处理
            }
        }
    }
}
