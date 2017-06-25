package com.company.ch11OpenSource.item141.section7;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;

public class Client {
    public static void main(String[] args) throws Exception {
        User user = new User("张三", 18);
        //转换工具
        ConvertUtilsBean cub = new ConvertUtilsBean();
        //注册一个转换器
        cub.register(new Converter() {
            public Object convert(Class type, Object value) {
                //为每个String类型的属性加上前缀
                return "prefix-" + value;
            }
        }, String.class);
        //建立一个依赖特定转换工具的Bean工具类
        BeanUtilsBean beanUtils = new BeanUtilsBean(cub);
        System.out.println(beanUtils.getProperty(user, "name"));
    }
}
