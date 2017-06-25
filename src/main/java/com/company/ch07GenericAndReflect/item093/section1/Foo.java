package com.company.ch07GenericAndReflect.item093.section1;

import java.util.List;

public class Foo {
    //arrayMethod接收数组参数，并进行重载
    public void arrayMethod(String[] strArray) {
    }

    public void arrayMethod(Integer[] intArray) {
    }

    //listMethod接收泛型List参数，并进行重载
    public void listMethod(List<String> stringList) {
    }
//	public void listMethod(List l){
//		
//	}
}
