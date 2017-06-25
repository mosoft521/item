package com.company.ch05ArrayAndCollection.item078.section;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clientbak {
    public static void main(String[] args) {
        //并发数量为50
        for (int i = 0; i < 500000; i++) {
            Map<Account, List<Transaction>> maps = new HashMap<Account, List<Transaction>>();
            List<Transaction> lists = new ArrayList<Transaction>();
            lists.add(new Transaction("类型1", "5000"));
            lists.add(new Transaction("类型2", "25000"));
            maps.put(new Account("账号" + i), lists);
        }
    }
}

class Account {
    String id;

    public Account(String _id) {
        id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class Transaction {
    private String type;
    private String money;

    public Transaction(String _type, String _money) {
        type = _type;
        money = _money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
