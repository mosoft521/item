package alvintest.emoji;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 001620 on 2014/10/13.
 */
public class EmojiUtil {
    private static final String START_CHAR = "[";
    private static final String END_CHAR = "]";

    private EmojiUtil() {
    }

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
        boolean b = (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
        return !b;
    }

    public static String convert(byte[] bytes) {
        try {
            String str = new String(bytes, Charset.forName("UTF-16"));
            int[] result = toCodePointArray(str);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                sb.append(Integer.toHexString(result[i]));
            }
//            int codePoint = str.codePointAt(0);
//            String hex_result = Integer.toHexString(codePoint);
            return sb.toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static int[] toCodePointArray(String str) {
        char[] ach = str.toCharArray();
        int len = ach.length;
        int[] acp = new int[Character.codePointCount(ach, 0, len)];
        int j = 0;
        for (int i = 0, cp; i < len; i += Character.charCount(cp)) {
            cp = Character.codePointAt(ach, i);
            acp[j++] = cp;
        }
        return acp;
    }

    private static byte[] getBytes(char[] chars) {
        int size = chars.length;
        byte[] b = new byte[size * 2];
        for (int i = 0; i < size; i++) {
            char c = chars[i];
            b[2 * i] = (byte) ((c & 0xFF00) >> 8);
            b[2 * i + 1] = (byte) (c & 0xFF);
        }
        return b;
    }

    private static char[] getChars(byte[] bytes) {
        Charset cs = Charset.forName("UTF-16");
        ByteBuffer bb = ByteBuffer.allocate(bytes.length);
        bb.put(bytes);
        bb.flip();
        CharBuffer cb = cs.decode(bb);

        return cb.array();
    }

    /**
     * 对字符串里的EMOJI表情编码。
     *
     * @param source
     * @return
     */
    public static String encodeEmoji(String source) throws UnsupportedEncodingException {

        Pattern pattern = Pattern.compile("^:[A-Za-z_]+:$");

        if (!containsEmoji(source)) {
            return source;//如果不包含，直接返回
        }
        //到这里铁定包含
        StringBuilder buf = null;

        int len = source.length();

        int skip = 0;
        for (int i = 0; i < len; i++) {
            if (skip > 0) {
                --skip;
            } else {
                char codePoint = source.charAt(i);

                if (isEmojiCharacter(codePoint)) {
                    if (buf == null) {
                        buf = new StringBuilder(source.length());
                    }
                    //convert
                    for (int j = 0; j < 4; j++) {
                        skip = j;
                        String tmp = source.substring(i, i + j + 1);
                        byte[] bytes = getBytes(tmp.toCharArray());
                        String c = convert(bytes);
                        String c2 = EmojiParser.emojiText(START_CHAR + c + END_CHAR);
                        Matcher matcher = pattern.matcher(c2);
                        boolean flg = matcher.find();
                        if (flg) {
                            buf.append(c2);
                            break;
                        }
                    }
                } else {
                    if (buf == null) {
                        buf = new StringBuilder(source.length());
                    }
                    buf.append(codePoint);
                }
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

    /**
     * 对字符串里的EMOJI表情解码。
     *
     * @param source
     * @return
     */
    public static String decodeEmoji(String source) throws UnsupportedEncodingException {
        Pattern pattern = Pattern.compile(":[A-Za-z_]+:");
//        Pattern pattern2 = Pattern.compile("(\\[[0-9A-Fa-f]+\\])");
        Pattern pattern2 = Pattern.compile("(\\[[a-z0-9]{5}\\])");
        Matcher matcher = pattern.matcher(source);
        boolean flg = matcher.find();
        if (!flg) {
            return source;
        } else {
            //处理
            //到这里铁定包含
            String decodeEmoji = EmojiParser.demojizedText(source);
            System.out.println(decodeEmoji);

//            StringBuilder buf = null;
//            if (buf == null) {
//                buf = new StringBuilder(source.length());
//            }
//            Matcher m = pattern2.matcher(decodeEmoji);
//            while (m.find()) {
//                buf.append(m.group(1));
//            }
//            return buf.toString();

            //todo:
            String returnTextString = decodeEmoji;
            //Pattern to match
            Matcher matcher2 = pattern2.matcher(decodeEmoji);
            while (matcher2.find()) {
                String found = matcher2.group();//[1f604]
                String toReplace = found.substring(1, found.length() - 1);
//                byte[] bytes = hexStringToByte(toReplace.toUpperCase());
                int codepoint = Integer.parseInt(toReplace, 16);

                returnTextString = returnTextString.replace(found, new String(Character.toChars(codepoint)));
            }
            //Returning text
            return returnTextString;
        }
    }

    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        String s = "<body>😄213这是一个有各种内容的消息,  Hia Hia Hia !!!! xxxx@@@...*)!" +
//                "(@*$&@(&#!)@*)!&$!)@^%@(!&#. 😄👩👨], ";
//        String c = encodeEmoji(s);
//        System.out.println(c);
////        assertFalse(s.equals(c));
//        String expected = "<body>213这是一个有各种内容的消息,  Hia Hia Hia !!!! xxxx@@@...*)" +
//                "!(@*$&@(&#!)@*)!&$!)@^%@(!&#. ], ";
////        assertEquals(expected, c);
////        assertSame(c, expected);
////        assertSame(expected, "<body>213这是一个有各种内容的消息,  Hia Hia Hia !!!! xxxx@@@...*)" +
////                "!(@*$&@(&#!)@*)!&$!)@^%@(!&#. ], ");
////        assertSame(c, encodeEmoji(c));


//        int i01 = 55357;
//        String s01 = Integer.toHexString(i01);
//        System.out.println(s01.toUpperCase());
//        int i02 = 56841;
//        String s02 = Integer.toHexString(i02);
//        System.out.println(s02.toUpperCase());
//
//        byte[] alvinBytes = {-40, 61, -34, 10};
////        byte[] alvinBytes = {79, 96, -40, 61, -34, 10, 89, 125};
//        String emojiAndroid = new String(alvinBytes, "utf-16");//安卓传过来的类似字符串
//        System.out.println("Android Input String: #" + emojiAndroid + "#");

        String emojiAndroid = "ni😄😄好😄😄";
        String c2 = encodeEmoji(emojiAndroid);
        System.out.println("c2: " + c2);

        String c3 = decodeEmoji(c2);
        System.out.println("c3: " + c3);

    }
}
