package com.company.ch07GenericAndReflect.item108.section2;

public class Client {
    public static void main(String[] args) throws Exception {
        AbsPopulator pop = new UserPopulator();
        pop.dataInitialing();
    }
}
