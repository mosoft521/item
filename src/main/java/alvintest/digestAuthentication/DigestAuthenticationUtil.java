package alvintest.digestAuthentication;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 001620 on 2014/10/18.
 */
public class DigestAuthenticationUtil {
    private static String secret = "abcdefghijklmn";

    private DigestAuthenticationUtil() {
    }

    public static String getDigest(Map<String, String> params) throws Exception {
        Set<String> keySet = params.keySet();
        //使用TreeSet排序
        TreeSet<String> stringTreeSet = new TreeSet<String>();
        stringTreeSet.addAll(keySet);
        String keyValueStr = "";
        Iterator<String> stringIterator = stringTreeSet.iterator();
        while (stringIterator.hasNext()) {
            String key = stringIterator.next();
            String value = params.get(key);
            keyValueStr += key + value;
        }
        keyValueStr += secret;
        String base64Str = byte2Base64(getMD5(keyValueStr));
        return base64Str;
    }

    public static boolean validate(Map params, String digest) throws Exception {
        Set<String> keySet = params.keySet();
        //使用TreeSet排序
        TreeSet<String> stringTreeSet = new TreeSet<String>();
        stringTreeSet.addAll(keySet);
        String keyValueStr = "";
        Iterator<String> stringIterator = stringTreeSet.iterator();
        while (stringIterator.hasNext()) {
            String key = stringIterator.next();
            String[] value = (String[]) params.get(key);
            keyValueStr += key + value;
        }
        keyValueStr += secret;
        String base64Str = byte2Base64(getMD5(keyValueStr));
        if (base64Str.equals(digest)) {
            return true;
        } else {
            return false;
        }
    }

    public static String getDigest(String content) throws Exception {
        content += secret;
        String base64Str = byte2Base64(getMD5(content));
        return base64Str;
    }

    public static boolean validate(String responseContent, String digest) throws Exception {
        String base64Str = byte2Base64(getMD5(responseContent + secret));
        if (base64Str.equals(digest)) {
            return true;
        } else {
            return false;
        }
    }

    public static String byte2Base64(byte[] bytes) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(bytes);
    }

    public static byte[] base642Byte(String base64) throws IOException {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        return base64Decoder.decodeBuffer(base64);
    }

    public static byte[] getMD5(String content) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(content.getBytes("utf8"));
        return bytes;
    }

    public static byte[] getSHA1(String content) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] bytes = md.digest(content.getBytes("utf8"));
        return bytes;
    }

    /**
     * byte数组转hex字符串<br/>
     * 一个byte转为2个hex字符
     *
     * @param src
     * @return
     */
    public static String bytes2Hex(byte[] src) {
        char[] res = new char[src.length * 2];
        final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0, j = 0; i < src.length; i++) {
            res[j++] = hexDigits[src[i] >>> 4 & 0x0f];
            res[j++] = hexDigits[src[i] & 0x0f];
        }

        return new String(res);
    }

    /**
     * hex字符串转byte数组<br/>
     * 2个hex转为一个byte
     *
     * @param src
     * @return
     */
    public static byte[] hex2Bytes(String src) {
        byte[] res = new byte[src.length() / 2];
        char[] chs = src.toCharArray();
        for (int i = 0, c = 0; i < chs.length; i += 2, c++) {
            res[c] = (byte) (Integer.parseInt(new String(chs, i, 2), 16));
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        byte[] md5 = getMD5("1111111");
        System.out.println(bytes2Hex(md5).toLowerCase());//7fa8282ad93047a4d6fe6111c93b308a

        md5 = getMD5("1234567");
        System.out.println(bytes2Hex(md5).toLowerCase());//fcea920f7412b5da7be0cf42b8c93759

        md5 = getMD5("123456");
        System.out.println(bytes2Hex(md5).toLowerCase());//e10adc3949ba59abbe56e057f20f883e

        md5 = getMD5("haowu");
        System.out.println(bytes2Hex(md5).toLowerCase());//2ee113d26eb3af55587b67c098f29db7

        md5 = getMD5("haowu.com");
        System.out.println(bytes2Hex(md5).toLowerCase());//23ec51f28bfd9789787195f582a7aad4
    }
}
