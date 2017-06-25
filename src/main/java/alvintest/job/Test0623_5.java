package alvintest.job;

/**
 * Created by Alvin on 2015/6/15.
 */
public class Test0623_5 implements Runnable {
    String myString = "Yes ";

    public static void main(String[] args) {
        Test0623_5 t = new Test0623_5();
        new Thread(t).start();
        for (int i = 0; i < 10; i++) {
            System.out.print(t.myString);
        }
    }

    public void run() {
        this.myString = "No ";
    }
}
