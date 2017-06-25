package alvintest.emoji;

/**
 * http://www.cnblogs.com/ayanamistltz/archive/2012/11/28/2793358.html
 * http://www.cnblogs.com/feixingfei/archive/2011/11/25/2297602.html
 * <p>
 * Created by Alvin on 2014/10/13 0013.
 */
public class HelloBunny {
    public static void main(String[] args) {
//        String sentence = "\u03C0 \uD835\uDD6B";
        String sentence = "ni😄😄好😄😄";
        int lengthU = sentence.length();
        int lengthP = sentence.codePointCount(0, lengthU);
        System.out.println(lengthU);        // 4个code units
        System.out.println(lengthP);        // 3个code points

        int codePointAt = sentence.codePointAt(2);    // i=2 true  i=0,1,3 false  i=4 out of bound
        System.out.println(codePointAt);
        boolean b = Character.isSupplementaryCodePoint(codePointAt);
        System.out.println(b);
    }
}