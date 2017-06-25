package alvintest;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alvin on 2014/7/7 0007.
 */
public class StringListTest {
    public static void main(String[] args) {
        List<String> s1 = new ArrayList<String>();
        s1.add("123");
        s1.add("321");
        for (String s : s1) {
            s = s + ",";
        }
        ArrayUtils.toString(s1.toArray());
    }
}
