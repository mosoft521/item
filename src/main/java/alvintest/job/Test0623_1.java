package alvintest.job;

/**
 * Created by Alvin on 2015/6/15.
 */
public class Test0623_1 {
    Test0623_1() {
        Test0623_1 alias1 = this;
        Test0623_1 alias2 = this;
        synchronized (alias1) {
            try {
                alias2.wait();
                System.out.println("DONE WAITING");
            } catch (InterruptedException e) {
                System.out.println("INTERRUPTED");
            } catch (Exception e) {
                System.out.println("Other Exception");
            } finally {
                System.out.println("Finally");
            }
        }
        System.out.println("ALL DONE");
    }

    public static void main(String[] args) {
        new Test0623_1();
    }
}
