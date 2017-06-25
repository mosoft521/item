package alvintest.job;

/**
 * Created by Alvin on 2015/6/15.
 */
public class Test0623_7 {

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");

        op(a, b);
        System.out.println(a + "," + b);
    }

    public static void op(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }
}
