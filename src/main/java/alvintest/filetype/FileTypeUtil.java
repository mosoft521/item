package alvintest.filetype;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 001620 on 2014/10/18.
 */
public class FileTypeUtil {

    private FileTypeUtil() {
    }

    private static String getFileHeader(String filePath) throws IOException {
        byte[] b = new byte[28];
        InputStream inputStream = null;
        inputStream = new FileInputStream(filePath);
        inputStream.read(b, 0, 28);
        inputStream.close();

        return bytes2Hex(b);
    }

    public static FileType getType(String filePath) throws IOException {
        String fileHead = getFileHeader(filePath);
        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }

        fileHead = fileHead.toUpperCase();
        FileType[] fileTypes = FileType.values();
        for (FileType fileType : fileTypes) {
            if (fileHead.startsWith(fileType.getValue())) {
                return fileType;
            }
        }
        return null;
    }

    // TODO:错误
//    public static String bytes2hex(byte[] bytes) {
//        StringBuilder hex = new StringBuilder();
//        for (int i = 0; i < bytes.length; i++) {
//            byte b = bytes[i];
//            boolean negative = false;//是否负数
//            if (b < 0) {
//                negative = true;
//            }
//            int inte = Math.abs(b);
//            if (negative) {
//                inte = inte | 0x80;
//            }
//            //负数会转成正数（最高位的负号变成数值计算），再转十六进制
//            String temp = Integer.toHexString(inte & 0xFF);
//            if (temp.length() == 1) {
//                hex.append("0");
//            }
//            hex.append(temp.toUpperCase());
//        }
//        return hex.toString();
//    }

//    /**
//     * java字节码转字符串
//     *
//     * @param b
//     * @return
//     */
//    public static String bytes2hex(byte[] b) { //一个字节的数，
//
//        // 转成16进制字符串
//
//        String hs = "";
//        String tmp = "";
//        for (int n = 0; n < b.length; n++) {
//            //整数转成十六进制表示
//
//            tmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
//            if (tmp.length() == 1) {
//                hs = hs + "0" + tmp;
//            } else {
//                hs = hs + tmp;
//            }
//        }
//        tmp = null;
//        return hs.toUpperCase(); //转成大写
//    }

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

//    public static byte[] hex2bytes(String hex) {
//        byte[] bytes = new byte[hex.length() / 2];
//        for (int i = 0; i < hex.length(); i = i + 2) {
//            String subStr = hex.substring(i, i + 2);
//            boolean negative = false;
//            int inte = Integer.parseInt(subStr, 16);
//            if (inte > 127) {
//                negative = true;
//            }
//            if (inte == 128) {
//                inte = -128;
//            } else if (negative) {
//                inte = 0 - (inte & 0x7F);
//            }
//            byte b = (byte) inte;
//            bytes[i / 2] = b;
//        }
//        return bytes;
//    }

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

    public static void main(String[] args) throws IOException {
//        FileType fileType = getType("D:\\用户目录\\Documents\\Tencent Files\\467513677\\FileRecv\\街道划分.png");
        FileType fileType = getType("D:\\用户目录\\Documents\\Tencent Files\\467513677\\FileRecv\\街道划分");
//        FileType fileType = getType("D:\\用户目录\\Documents\\Tencent Files\\467513677\\FileRecv\\外卖单集锦.rar");
        System.out.println(fileType);

//        byte[] bytes = hex2Bytes("89504E470D0A1A0A0000000D49484452000004800000028808020000");
//        System.out.println(bytes);
    }
}
