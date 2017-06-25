package com.company.ch05ArrayAndCollection.item066.section1;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //工作日
        Week[] workDays = {Week.Mon, Week.Tue, Week.Wed, Week.Thu, Week.Fri};
        //转换为列表
        List<Week> list = Arrays.asList(workDays);
        //增加周六也为工作日
        list.add(Week.Sat);
        /*工作日开始干活了*/
    }

    //枚举，声明一个星期
    enum Week {
        Sun, Mon, Tue, Wed, Thu, Fri, Sat
    }
}
