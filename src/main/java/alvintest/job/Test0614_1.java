package alvintest.job;

/**
 * Created by Alvin on 2015/6/15.
 */
public class Test0614_1 {
    public void method() {
        String a, b;
        a = new String("hello world");
        b = new String("game over");
        System.out.println(a + b + "ok");
        a = null;
        a = b;
        System.out.println(a);

    }
}
