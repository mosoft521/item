package alvintest;

import java.util.Random;

/**
 * @author WangLei createtIime:2014-下午5:46:10
 *         <p/>
 *         Copyright © 2012 - 2013 Haowu.cn. All Rights Reserved. 好屋中国 版权所有
 */
public class HossUtil {
    public static final String SMS_URL = "/institution/sms/send";


    /**
     * 随机字符码
     *
     * @param size 生成的字符个数
     * @return 数字字符串
     */
    public static String buildRandomCode(int size) {
        Random random = new Random();
        char[] source = "0123456789".toCharArray();
        char[] result = new char[size];
        int rnd;
        for (int i = 0; i < size; i++) {
            rnd = Math.abs(random.nextInt()) % source.length;
            result[i] = source[rnd];
        }
        return new String(result);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(buildRandomCode(4));
        }
    }
}
