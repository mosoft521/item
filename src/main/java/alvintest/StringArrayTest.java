package alvintest;

import org.apache.commons.lang.StringUtils;

public class StringArrayTest {

    public static void main(String[] args) {
        String s1 = "s1";
        String s2 = null;
        String s3 = "s3";
        String s4 = "s4";

        String[] sss = new String[]{s1, s2, s3, s4};
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String s : sss) {
            if (StringUtils.isNotBlank(s)) {
                if (!first) {
                    sb.append("*");
                }
                sb.append(s);
                first = false;
            }
        }
        String spec = sb.toString();
        System.out.println(spec);
    }

}
