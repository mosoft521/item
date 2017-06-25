package alvintest;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * Created by 001620 on 2014/9/19.
 */
public class CsvAlvin {
    /**
     * 7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块
     */
    public static final String US_ASCII = "US-ASCII";
    /**
     * ISO 拉丁字母表 No.1，也叫作 ISO-LATIN-1
     */
    public static final String ISO_8859_1 = "ISO-8859-1";
    /**
     * 8 位 UCS 转换格式
     */
    public static final String UTF_8 = "UTF-8";
    /**
     * 16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识
     */
    public static final String UTF_16 = "UTF-16";
    /**
     * 中文超大字符集
     */
    public static final String GBK = "GBK";

    /**
     * 字符串编码转换的实现方法
     *
     * @param str        待转换编码的字符串
     * @param oldCharset 原编码
     * @param newCharset 目标编码来源：考试大的美女编辑们
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    public static String changeCharset(String str, String oldCharset, String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            //用旧的字符编码解码字符串。解码可能会出现异常。
            byte[] bs = str.getBytes(oldCharset);
            //用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return null;
    }

    //Double longitude, Double latitude,
    public static void main(String[] args) throws Exception {
//        Reader in = new FileReader("path/to/file.csv");
        Reader in = new FileReader("E:\\doc-hw-project\\from_jjp\\高德系列（谷歌、mapabc等）poi_amap_csv\\上海市\\上海市市辖区.csv");
//        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
//        for (CSVRecord record : records) {
//            String longitude = record.get(1);
//            String latitude = record.get(2);
//            String name = record.get(3);
//            String address = record.get(4);
//            String tel = record.get(5);
//            String category = record.get(6);
//            String zip = record.get(7);
//
//            System.out.println("经度：" + longitude);
//            System.out.println("纬度：" + " " + latitude);
//            System.out.println("名称：" + " " + name);
//            System.out.println("地址：" + " " + address);
//            System.out.println("电话：" + " " + tel);
//            System.out.println("分类：" + " " + category);
//            System.out.println("邮编：" + " " + zip);
//        }

        CSVRecord record = records.iterator().next();
        String longitude = record.get(1);
        String latitude = record.get(2);
        String name = record.get(3);
        String address = record.get(4);
        String tel = record.get(5);
        String category = record.get(6);
        String zip = record.get(7);

        System.out.println("经度：" + longitude);
        System.out.println("纬度：" + " " + latitude);
        System.out.println("名称：" + " " + name);
        System.out.println("名称：" + " " + changeCharset(changeCharset(name, US_ASCII, GBK), GBK, UTF_16));
        System.out.println("地址：" + " " + address);
        System.out.println("电话：" + " " + tel);
        System.out.println("分类：" + " " + category);
        System.out.println("邮编：" + " " + zip);
    }

}
