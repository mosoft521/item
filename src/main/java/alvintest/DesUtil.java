package alvintest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class DesUtil {

    private final static String DES = "DES";
    private final static String MD5 = "Md5";

    public static String encodeMd5(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(MD5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageDigest.reset();
        try {
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }

        return md5StrBuff.toString();
    }

    public static String getHexString(byte[] b) throws Exception {
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
        }
        return result.toUpperCase();
    }

    public static byte[] getByteArray(String hexString) {
        return new BigInteger(hexString, 16).toByteArray();
    }

    public static void main(String[] args) throws Exception {
//        String data = "123456";
//        String key = "wang!@#$%";
//        System.err.println(encrypt(data, key));
//        System.err.println(decrypt(encrypt(data, key), key));


        //AlvinTest1
//        byte[] data2 = "abcdef".getBytes();
//        byte[] key2 = encodeMd5("md5").substring(0,8).getBytes();
//        System.err.println(getHexString(data2));
//        System.err.println(getHexString(encrypt(data2, key2)));
//        System.err.println(getHexString(decrypt(encrypt(data2, key2), key2)));

        //AlvinTest2
//        byte[] data2 = "password123456".getBytes();
//        byte[] key2 = "4fab2efe".getBytes();
//        System.err.println(getHexString(data2));
//        System.err.println(getHexString(encrypt(data2, key2)));
//        System.err.println(getHexString(decrypt(encrypt(data2, key2), key2)));

        //AlvinTest3
//        byte[] data2 = "123456".getBytes();
//        byte[] key2 = encodeMd5("md5").substring(0,8).toUpperCase().getBytes();
//        System.err.println(getHexString(data2));
//        System.err.println(getHexString(desEncrypt(data2, key2)));
//        System.err.println(getHexString(desDecrypt(desEncrypt(data2, key2), key2)));


        //AlvinTest4
//        byte[] sdata4 = getByteArray("0EB223858E6AE338");
        byte[] sdata4 = getByteArray("552C1CA0E1FF2392262D48AB02D5DF19");
        byte[] data4 = new byte[8];
        if (sdata4.length == 9) {
            System.arraycopy(sdata4, 1, data4, 0, 8);
        } else {
            data4 = sdata4;
        }
        String ss = encodeMd5("md5").substring(0, 8).toUpperCase();
        byte[] key4 = encodeMd5("md5").substring(0, 8).toUpperCase().getBytes();
        System.err.println(getHexString(data4));
        System.err.println(new String(desDecrypt(data4, key4), "utf-8"));
    }

    //add by AlvinTest3
    public static byte[] desEncrypt(byte[] data, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

        DESKeySpec desKeySpec = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        return cipher.doFinal(data);
    }

    //add by AlvinTest4
    public static byte[] desDecrypt(byte[] data, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

        DESKeySpec desKeySpec = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        return cipher.doFinal(data);
    }

//    /**
//     * Description 根据键值进行加密
//     *
//     * @param data
//     * @param key  加密键byte数组
//     * @return
//     * @throws Exception
//     */
//    public static String encrypt(String data, String key) throws Exception {
//        byte[] bt = encrypt(data.getBytes(), key.getBytes());
//        String strs = new BASE64Encoder().encode(bt);
//        return strs;
//    }
//
//    /**
//     * Description 根据键值进行解密
//     *
//     * @param data
//     * @param key  加密键byte数组
//     * @return
//     * @throws IOException
//     * @throws Exception
//     */
//    public static String decrypt(String data, String key) throws IOException,
//            Exception {
//        if (data == null)
//            return null;
//        BASE64Decoder decoder = new BASE64Decoder();
//        byte[] buf = decoder.decodeBuffer(data);
//        byte[] bt = decrypt(buf, key.getBytes());
//        return new String(bt);
//    }

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }


    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }
}
