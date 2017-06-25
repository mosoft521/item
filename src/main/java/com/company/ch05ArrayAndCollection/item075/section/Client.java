package com.company.ch05ArrayAndCollection.item075.section;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<City>();
        cities.add(new City("021", "上海"));
        cities.add(new City("021", "沪"));
        City city = new City("021", "沪");
        //排序
        Collections.sort(cities);
        // indexOf方法取得索引值
        int index1 = cities.indexOf(city);
        // binarySearch查找到索引值
        int index2 = Collections.binarySearch(cities, city);
        System.out.println("索引值(indexOf)：" + index1);
        System.out.println("索引值（binarySearch)：" + index2);
    }
}

class City implements Comparable<City> {
    //城市编码
    private String code;
    //城市名称
    private String name;

    public City(String _code, String _name) {
        code = _code;
        name = _name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(City o) {
        // 按照城市名称排序
        return new CompareToBuilder().append(name, o.name).toComparison();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        City city = (City) obj;
        //根据code判断是否相等
        return new EqualsBuilder()
                .append(code, city.code)
                .isEquals();
    }
}
