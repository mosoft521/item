package alvintest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 001620 on 2014/9/19.
 */
public class RegExpAlvin {
    public static void main(String[] args) {
        boolean checkFlag = true;
//        String zip = "310101";
//        String zip = ":smile:";
        String zip = ":twisted_rightwards_arrows:";
//        Pattern pattern = Pattern.compile("\\d{6}");
        Pattern pattern = Pattern.compile("^:[A-Za-z_]+:$");
        Matcher matcher = pattern.matcher(zip);
        boolean flg = matcher.find();

        if (flg) {
            System.out.println(flg);
        } else {
            checkFlag = false;
        }
    }
}
