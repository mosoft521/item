package com.company.ch07GenericAndReflect.item099.section1;

//职员
interface Staff {
    //工资
    public int getSalary();
}

//乘客
interface Passenger {
    //是否是站立状态
    public boolean isStanding();
}

public class Client {
    //工资低于2500元的上斑族并且站立的乘客车票打8折
    public static <T extends Staff & Passenger> void discount(T t) {
        if (t.getSalary() < 2500 && t.isStanding()) {
            System.out.println("恭喜你！您的车票打八折！");
        }
    }

    public static void main(String[] args) {
        discount(new Me());
    }
}

class Me implements Staff, Passenger {
    public boolean isStanding() {
        return true;
    }

    public int getSalary() {
        return 2000;
    }
}
