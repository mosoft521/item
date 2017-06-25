package alvintest.job;

/**
 * Created by Alvin on 2015/6/15.
 */
public class Test0623_2 {
    static int x, y;

    public static void main(String[] args) {
        x--;
        System.out.println(x + ", " + y);
        myMethod();
        System.out.println(x + ", " + y);
        System.out.println(x + y + ++x);
        System.out.println(x + ", " + y);
    }

    public static void myMethod() {
        y = x++ + ++x;
    }
}
