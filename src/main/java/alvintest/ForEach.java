package alvintest;

import java.util.ArrayList;
import java.util.List;

public class ForEach {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<String>();
        for (String s : strList) {
            System.out.println("123");
        }

        List<TestBean> testBeans = new ArrayList<TestBean>();
        for (TestBean testBean : testBeans) {
            System.out.println("456");
        }

        TestBean testBean = new TestBean();
        for (String s : testBean.getStrList()) {
            System.out.println("789");
        }

    }
}
