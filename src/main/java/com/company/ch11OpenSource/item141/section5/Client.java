package com.company.ch11OpenSource.item141.section5;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.LazyDynaBean;
import org.apache.commons.beanutils.PropertyUtils;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setAge(10);
        user.setName("张三");
        Person person = new Person();
        // 两个Bean属性拷贝
        PropertyUtils.copyProperties(person, user);
        System.out.println(person.getName());
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "aa1");
        // 把Map中的键值对拷贝到Bean上
        PropertyUtils.copyProperties(person, map);
        System.out.println(person.getName());
        // 动态Bean，首先定义Bean类
        DynaProperty[] props = new DynaProperty[]{
                new DynaProperty("name", String.class),
                new DynaProperty("age", int.class)};
        BasicDynaClass dynaClass = new BasicDynaClass("people", null, props);
        //动态Bean对象
        DynaBean people = dynaClass.newInstance();
        people.set("name", "张三");
        System.out.println(people.get("name"));
        //懒惰式Bean
        DynaBean dynaBean = new LazyDynaBean();
        dynaBean.set("foo", 0, "dd");
        System.out.println(dynaBean.get("foo"));
    }
}
