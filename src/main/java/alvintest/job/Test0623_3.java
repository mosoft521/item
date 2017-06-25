package alvintest.job;

/**
 * Created by Alvin on 2015/6/15.
 */
class Value {
    public int i = 15;
}

public class Test0623_3 {
    static int x, y;

    public static void main(String[] args) {
        Test0623_3 t = new Test0623_3();
        t.first();
    }

    public void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }

    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + " " + i);
    }

}
