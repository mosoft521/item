package alvintest.emoji;

/**
 * Created by Alvin on 2014/10/13 0013.
 */
public class CodePointAlvinTest {
    public static void main(String[] args) {
//        String greeting = "Hello";
        String greeting = "ni😄😄好😄😄";
        int length = greeting.length(); // is 5
        System.out.println(length); //5:11
        int cpCount = greeting.codePointCount(0, greeting.length());//代码点数量
        System.out.println(cpCount);//5:7

        char first = greeting.charAt(0);   // first is 'H'
        char last = greeting.charAt(4);   // last is 'o'
        System.out.println(first);// n
        System.out.println(last);// ?

        //得到第i个代码单元
        int index = greeting.offsetByCodePoints(0, 4);
        int cp = greeting.codePointAt(index);
        System.out.println(cp);

        String sentence = "ni😄😄好😄😄";
        System.out.println("cp2:");
        // 遍历
        for (int i = 0; i < 7; i++) {
            int cp2 = sentence.codePointAt(i);
            System.out.println(cp2);
            if (Character.isSupplementaryCodePoint(cp2)) {
                i += 2;
            } else {
                i++;
            }
        }
    }
}
