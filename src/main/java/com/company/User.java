package com.company;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 758747530301974781L;

    private int id;
    private String name;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
