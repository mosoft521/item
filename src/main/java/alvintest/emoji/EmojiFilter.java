package alvintest.emoji;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * Created by 001620 on 2014/10/13.
 */
public class EmojiFilter {

    /**
     * 检测是否有emoji字符
     *
     * @param source
     * @return 一旦含有就抛出
     */
    public static boolean containsEmoji(String source) {
        if (StringUtils.isBlank(source)) {
            return false;
        }

        int len = source.length();

        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);

            if (isEmojiCharacter(codePoint)) {
                //do nothing，判断到了这里表明，确认有表情字符
                return true;
            }
        }

        return false;
    }

    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) ||
                (codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

    /**
     * 过滤emoji 或者 其他非文字类型的字符
     *
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {

        if (!containsEmoji(source)) {
            return source;//如果不包含，直接返回
        }
        //到这里铁定包含
        StringBuilder buf = null;

        int len = source.length();

        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);

            if (isEmojiCharacter(codePoint)) {
                if (buf == null) {
                    buf = new StringBuilder(source.length());
                }

                buf.append(codePoint);
            } else {
            }
        }

        if (buf == null) {
            return source;//如果没有找到 emoji表情，则返回源字符串
        } else {
            if (buf.length() == len) {//这里的意义在于尽可能少的toString，因为会重新生成字符串
                buf = null;
                return source;
            } else {
                return buf.toString();
            }
        }

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        String s = "<body>😄213这是一个有各种内容的消息,  Hia Hia Hia !!!! xxxx@@@...*)!" +
//                "(@*$&@(&#!)@*)!&$!)@^%@(!&#. 😄👩👨], ";
//        String c = filterEmoji(s);
//        System.out.println(c);
////        assertFalse(s.equals(c));
//        String expected = "<body>213这是一个有各种内容的消息,  Hia Hia Hia !!!! xxxx@@@...*)" +
//                "!(@*$&@(&#!)@*)!&$!)@^%@(!&#. ], ";
//        assertEquals(expected, c);
//        assertSame(c, expected);
//        assertSame(expected, "<body>213这是一个有各种内容的消息,  Hia Hia Hia !!!! xxxx@@@...*)" +
//                "!(@*$&@(&#!)@*)!&$!)@^%@(!&#. ], ");
//        assertSame(c, filterEmoji(c));


        int i01 = 55357;
        String s01 = Integer.toHexString(i01);
        System.out.println(s01.toUpperCase());
        int i02 = 56841;
        String s02 = Integer.toHexString(i02);
        System.out.println(s02.toUpperCase());

        byte[] alvinBytes = {-40, 61, -34, 10};
//        byte[] alvinBytes = {79, 96, -40, 61, -34, 10, 89, 125};
        String emojiAndroid = new String(alvinBytes, "utf-16");//安卓传过来的类似字符串
        System.out.println("Android Input String: #" + emojiAndroid + "#");
        String c2 = filterEmoji(emojiAndroid);
        System.out.println(c2);

    }
}