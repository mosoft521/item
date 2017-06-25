package com.company.ch02PrimitiveType.item025.section2;

public class Client {
    public static void main(String[] args) {
        //银行账户数量，千万
        int accountNum = 5000 * 10000;
        //按照人行的规定，每个季度末月的20日为银行结息日
        double cost = 0.0005 * accountNum * 4;
        System.out.println("银行每年损失的金额：" + cost);
    }
}
