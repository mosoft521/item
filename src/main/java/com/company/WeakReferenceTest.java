package com.company;

import java.lang.ref.SoftReference;

public class WeakReferenceTest {

    private SoftReference<User> ref;

    public static void main(String[] args) {
        WeakReferenceTest weakReferenceTest = new WeakReferenceTest();
        weakReferenceTest.doSomeThing();
        weakReferenceTest.doAnotherThing();
    }

    public void doSomeThing() {
        User user = new User();
        user.setId(11);
        user.setName("Alvin");
        ref = new SoftReference<User>(user);
    }

    public void doAnotherThing() {
        User user = ref.get();
        System.out.println(user);
    }
}
