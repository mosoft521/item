package alvintest.exceptiontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alvin on 2014/10/19 0019.
 */
public class BuggyEchoInput {
    public static void main(String[] args) {
        System.out.println("Enter text to echo");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader inputReader = new BufferedReader(isr);
        try {
            String inputLine = inputReader.readLine();
            System.out.println("READ: " + inputLine);
        } catch (IOException exc) {
//            e.printStackTrace();
            System.out.println("Exception encountered: " + exc);
        }
    }
}
