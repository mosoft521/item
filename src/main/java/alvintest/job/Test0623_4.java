package alvintest.job;

/**
 * Created by Alvin on 2015/6/15.
 */
class X {
    Y b = new Y();

    X() {
        System.out.println("X");
    }
}

class Y {
    Y() {
        System.out.println("Y");
    }
}

class Z extends X {
    Y y = new Y();

    Z() {
        System.out.println("Z");
    }
}

public class Test0623_4 {

    public static void main(String[] args) {
        new Z();
    }
}
