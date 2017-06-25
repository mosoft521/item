package alvintest.job;

/**
 * Created by Alvin on 2015/6/15.
 */
class Foo {
    private int x;

    public Foo(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

public class Test0623_8 {

    static Foo fooBar(Foo foo) {
        foo = new Foo(100);
        return foo;
    }

    public static void main(String[] args) {
        Foo foo = new Foo(300);
        System.out.print(foo.getX() + "-");

        Foo fooBar = fooBar(foo);
        System.out.print(foo.getX() + "-");
        System.out.print(fooBar.getX() + "-");

        foo = fooBar(fooBar);
        System.out.print(foo.getX() + "-");
        System.out.print(fooBar.getX());
    }

    public static void op(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }
}
