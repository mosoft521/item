package alvintest;

/**
 * Created by 001620 on 2014/10/10.
 */
public class NeverCaught {
    static void f() throws ExceptionB {
        throw new ExceptionB("exception b");
    }

    static void g() throws ExceptionC {
        try {
            f();
        } catch (ExceptionB e) {
            ExceptionC c = new ExceptionC("exception a");
            throw c;
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (ExceptionC e) {
            e.printStackTrace();
        }
    }

}