package com.company.ch11OpenSource.item141.section6;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.LazyDynaBean;

public class Client {
    public static void main(String[] args) throws Exception {
        // 动态Bean，首先定义Bean类
        DynaProperty[] props = new DynaProperty[]{
                new DynaProperty("name", String.class),
                new DynaProperty("age", int.class)};
        BasicDynaClass dynaClass = new BasicDynaClass("people", null, props);
        // 动态Bean对象
        DynaBean people = dynaClass.newInstance();
        people.set("name", "张三");
        System.out.println(people.get("name"));
        // 自由Bean
        DynaBean user = new LazyDynaBean();
        // 直接定义属性和值
        user.set("name", "张三");
        System.out.println(user.get("name"));
        // 定义属性名，限定属性类型为Map
        user.set("phoneNum", "tel", "021");
        user.set("phoneNum", "mobile", "138");
        // 属性类型为ArrayList
        user.set("address", 0, "上海");
        user.set("address", 1, "北京");
        System.out.println(user.get("address").getClass());
    }
}