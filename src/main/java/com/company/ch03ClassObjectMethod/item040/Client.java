package com.company.ch03ClassObjectMethod.item040;

//定义一个枚举，限定操作符
enum Ops {
    ADD, SUB
}

public class Client {
    public static void main(String[] args) {
        Calculator c1 = new Calculator(1, 2) {
            {
                setOperator(Ops.SUB);
            }
        };
        Calculator c2 = new Add(1, 2);
        System.out.println(c1.getResult());
        System.out.println(c2.getResult());
    }
}

class Calculator {
    private int i, j, result;

    //无参构造
    public Calculator() {
    }

    //有参构造
    public Calculator(int _i, int _j) {
        i = _i;
        j = _j;
    }

    //设置符号，是加法运算还是减法运算
    protected void setOperator(Ops _op) {
        result = _op.equals(Ops.ADD) ? i + j : i - j;
    }

    //取得运算结果
    public int getResult() {
        return result;
    }
}

//加法计算
class Add extends Calculator {
    {
        setOperator(Ops.ADD);
    }

    //覆写父类的构造方法
    public Add(int _i, int _j) {
        super(_i, _j);
    }
}