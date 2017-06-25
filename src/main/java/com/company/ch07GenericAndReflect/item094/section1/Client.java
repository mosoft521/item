package com.company.ch07GenericAndReflect.item094.section1;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
    }
}

class Foo<T> {
    //	private T t =new T();
//	private T[] tArray= new T[5];
    private List<T> list = new ArrayList<T>();
}
