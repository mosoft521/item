package com.company.ch06EnumAndAnnotation.item084.section2;

enum Role {
    Admin("管理员", new Lifetime(), new Scope()),
    User("普通用户", new Lifetime(), new Scope());
    //描述
    private String name;
    // 角色的生命期
    private Lifetime lifeTime;
    // 权限范围
    private Scope scope;

    Role(String _name, Lifetime _lt, Scope _scope) {
        name = _name;
        lifeTime = _lt;
        scope = _scope;
    }

    //角色名称
    public String getName() {
        return name;
    }

    // 获得角色的生命期
    public Lifetime getLifetime() {
        return lifeTime;
    }

    // 获得权限范围
    public Scope getScope() {
        return scope;
    }
}

public class Client {
}

class Lifetime {
}

class Scope {
}