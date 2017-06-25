package com.gmail.sq;

import com.gmail.sq.model.domain.CommunityShop;
import com.gmail.sq.model.domain.CommunityTenement;
import com.gmail.sq.model.domain.CommunityVillage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by 001620 on 2014/9/20.
 */
public class CsvAlvin2 {

    public static Map<Integer, Long> convertMap = new HashMap<Integer, Long>();

    static {
        convertMap.put(0, 201L);
        convertMap.put(1, 202L);
        convertMap.put(2, 203L);
        convertMap.put(3, 204L);
        convertMap.put(4, 205L);
        convertMap.put(5, 206L);
        convertMap.put(6, 207L);
        convertMap.put(7, 208L);
        convertMap.put(8, 209L);
        convertMap.put(9, 210L);
        convertMap.put(10, 211L);
        convertMap.put(11, 212L);
        convertMap.put(12, 213L);
        convertMap.put(13, 214L);
        convertMap.put(14, 215L);
        convertMap.put(15, 216L);
        convertMap.put(16, 217L);
        convertMap.put(17, 218L);
        convertMap.put(18, 219L);
        convertMap.put(19, 220L);
        convertMap.put(20, 221L);
        convertMap.put(21, 222L);
        convertMap.put(22, 223L);
        convertMap.put(23, 224L);
        convertMap.put(24, 225L);
        convertMap.put(25, 226L);
        convertMap.put(26, 227L);
        convertMap.put(27, 228L);
        convertMap.put(28, 229L);
        convertMap.put(29, 230L);
        convertMap.put(30, 231L);
        convertMap.put(31, 232L);
    }

    /**
     * 字符串编码转换的实现方法
     *
     * @param str        待转换编码的字符串
     * @param newCharset 目标编码来源：考试大的美女编辑们
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String changeCharset(String str, String newCharset)
            throws UnsupportedEncodingException {
        if (str != null) {
            //用默认字符编码解码字符串。
            byte[] bs = str.getBytes();
            //用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return null;
    }

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

    /**
     * @param path 查询文件路径
     * @return Map Boolean->true:文件夹；false：非文件夹，String：文件名/文件夹名
     */
    public static List<FileModel> queryAllFileName(String path) {

        // 查询路径
        File filePath = new File(path);
        // 路径不存在
        if (!filePath.exists()) {
            return null;
        }
        List<FileModel> fileModelList = new ArrayList<FileModel>();
        // 路径不是文件夹
        if (!filePath.isDirectory()) {
            FileModel file = new FileModel(false, path);
            fileModelList.add(file);
            return fileModelList;
        }
        // 取得路劲下文件名或文件夹名
        String[] fileNames = filePath.list();
        for (int i = 0; i < fileNames.length; i++) {
            // 判断是否为文件夹
            if ((new File(path + fileNames[i])).isDirectory()) {
                fileModelList.add(new FileModel(true, fileNames[i]));
            } else {
                fileModelList.add(new FileModel(false, fileNames[i]));
            }
        }
        return fileModelList;
    }

    //Double longitude, Double latitude,
    public static void main(String[] args) throws Exception {

        //        String url = "jdbc:mysql://localhost/hw-sq-alvin?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useLocalSessionState=true";
//        String user = "root";
//        String pass = "admin";
        String url = "jdbc:mysql://172.16.10.79/hw-sq-alvin?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useLocalSessionState=true";
        String user = "shequ_dev";
        String pass = "904";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        PreparedStatement stmtWy = null;
        PreparedStatement stmtVillage = null;
        PreparedStatement stmtSh = null;
        con = DriverManager.getConnection(url, user, pass);
        stmtWy = con.prepareStatement("insert into community_tenement(name, longitude,latitude,address) values (?,?,?,?)");
        stmtVillage = con.prepareStatement("insert into community_village(village_name, longitude,latitude,address) values (?,?,?,?)");
        stmtSh = con.prepareStatement("insert into community_shop(name, longitude,latitude,address,type) values (?,?,?,?,?)");


        con.setAutoCommit(false);

        boolean checkFlag = true;//校验标志
        Pattern patternZip = Pattern.compile("^\\d{6}$"); //邮政编码正则：6位数字

        Pattern patternCategoryWy = Pattern.compile("公司企业;公司;公司"); //物业正则：
        Pattern patternNameWy = Pattern.compile("物业"); //物业正则：

        Pattern patternCategoryVillage = Pattern.compile("商务住宅;住宅区;|地名地址信息;行政地名;村庄级地名\\|地名地址信息;行政地名;村庄级地名\\|商务住宅"); //小区正则：

        //商户正则
        List<Pattern> patternCategorySh = new ArrayList<Pattern>(32);
        List<Pattern> patternNameSh = new ArrayList<Pattern>(5);
        //商户正则-0超市便利
        Pattern patternCategory00 = Pattern.compile("购物服务;便民商店/便利店;便民商店/便利店|购物服务;超级市场;|购物服务;商场;");
        patternCategorySh.add(patternCategory00);
        //商户正则-1美食
        Pattern patternCategory01 = Pattern.compile("餐饮服务;中餐厅;|餐饮服务;餐饮相关场所;|餐饮服务;外国餐厅;|住宿服务;宾馆酒店;|休闲餐饮场所;休闲餐饮场所;休闲餐饮场所|休闲餐饮场所;休闲餐饮场所;生活服务场所\\|餐饮服务|购物服务;购物相关场所;购物相关场所\\|餐饮服务|餐饮服务;快餐厅;");
        patternCategorySh.add(patternCategory01);
        //商户正则-2休闲小吃
        Pattern patternCategory02 = Pattern.compile("餐饮服务;甜品店;|餐饮服务;冷饮店;|餐饮服务;茶艺馆;|餐饮服务;咖啡厅;|餐饮服务;糕饼店;");
        patternCategorySh.add(patternCategory02);
        //商户正则-3水果
        Pattern patternCategory03 = Pattern.compile("购物服务;综合市场;果品市场");
        patternCategorySh.add(patternCategory03);
        //商户正则-4洗衣
        Pattern patternCategory04 = Pattern.compile("生活服务;洗衣店;");
        patternCategorySh.add(patternCategory04);
        //商户正则-5家政
        Pattern patternCategory05 = Pattern.compile("生活服务;生活服务场所;生活服务场所");
        patternCategorySh.add(patternCategory05);
        Pattern patternName05 = Pattern.compile("家政");
        patternNameSh.add(patternName05);
        //商户正则-6开锁换锁
        Pattern patternCategory06 = Pattern.compile("生活服务;生活服务场所;生活服务场所");
        patternCategorySh.add(patternCategory06);
        Pattern patternName06 = Pattern.compile("开锁");
        patternNameSh.add(patternName06);
        //商户正则-7快递
        Pattern patternCategory07 = Pattern.compile("生活服务;物流速递;");
        patternCategorySh.add(patternCategory07);
        //商户正则-8收废品
        Pattern patternCategory08 = Pattern.compile("公司企业;公司;公司");
        patternCategorySh.add(patternCategory08);
        Pattern patternName08 = Pattern.compile("废品");
        patternNameSh.add(patternName08);
        //商户正则-9管道疏通
        Pattern patternCategory09 = Pattern.compile("生活服务;生活服务场所;生活服务场所");
        patternCategorySh.add(patternCategory09);
        Pattern patternName09 = Pattern.compile("管道疏通");
        patternNameSh.add(patternName09);
        //商户正则-10五金
        Pattern patternCategory10 = Pattern.compile("购物服务;家居建材市场;");
        patternCategorySh.add(patternCategory10);
        //商户正则-11洗车
        Pattern patternCategory11 = Pattern.compile("汽车服务;洗车场;洗车场");
        patternCategorySh.add(patternCategory11);
        //商户正则-12汽车服务
        Pattern patternCategory12 = Pattern.compile("汽车维修;|汽车销售;|汽车服务;汽车养护/装饰;|汽车服务;汽车服务相关;汽车服务相关|汽车服务;加油站;|汽车服务;汽车租赁;汽车租赁|汽车服务;汽车救援;汽车救援|汽车服务;汽车配件销售;汽车配件销售|汽车服务;二手车交易;二手车交易");
        patternCategorySh.add(patternCategory12);
        //商户正则-13搬家
        Pattern patternCategory13 = Pattern.compile("生活服务;搬家公司;");
        patternCategorySh.add(patternCategory13);
        //商户正则-14送水
        Pattern patternCategory14 = Pattern.compile("生活服务;生活服务场所;生活服务场所|购物服务;专卖店;专营店");
        patternCategorySh.add(patternCategory14);
        Pattern patternName14 = Pattern.compile("送水");
        patternNameSh.add(patternName14);
        //商户正则-15美容护理
        Pattern patternCategory15 = Pattern.compile("生活服务;美容美发店;|生活服务;个人用品/化妆品店;|生活服务;洗浴推拿场所;洗浴推拿场所");
        patternCategorySh.add(patternCategory15);
        //商户正则-16家电维修
        Pattern patternCategory16 = Pattern.compile("生活服务;维修站点;维修站点");
        patternCategorySh.add(patternCategory16);
        //商户正则-17宠物
        Pattern patternCategory17 = Pattern.compile("医疗保健服务;动物医疗场所;动物医疗场所");
        patternCategorySh.add(patternCategory17);
        //商户正则-18文具
        Pattern patternCategory18 = Pattern.compile("购物服务;文化用品店;文化用品店");
        patternCategorySh.add(patternCategory18);
        //商户正则-19运动健身
        Pattern patternCategory19 = Pattern.compile("体育休闲服务;运动场馆;|体育休闲服务;体育休闲服务场所;体育休闲服务场所|购物服务;体育用品店;");
        patternCategorySh.add(patternCategory19);
        //商户正则-20培训机构
        Pattern patternCategory20 = Pattern.compile("科教文化服务;培训机构;培训机构|科教文化服务;科教文化场所;科教文化场所");
        patternCategorySh.add(patternCategory20);
        //商户正则-21医疗
        Pattern patternCategory21 = Pattern.compile("医疗保健服务;医药保健销售店;|医疗保健服务;诊所;诊所|医疗保健服务;综合医院;|医疗保健服务;急救中心;|医疗保健服务;专科医院;|医疗保健服务;疾病预防机构;疾病预防");
        patternCategorySh.add(patternCategory21);
        //商户正则-22银行
        Pattern patternCategory22 = Pattern.compile("金融保险服务;金融保险服务机构;金融保险机构|金融保险服务;银行;|金融保险服务;自动提款机;|金融保险服务;证券公司;|金融保险服务;银行相关;银行相关");
        patternCategorySh.add(patternCategory22);
        //商户正则-23花鸟市场
        Pattern patternCategory23 = Pattern.compile("购物服务;花鸟鱼虫市场;");
        patternCategorySh.add(patternCategory23);
        //商户正则-24彩票
        Pattern patternCategory24 = Pattern.compile("生活服务;彩票彩券销售点;彩票彩券销售点");
        patternCategorySh.add(patternCategory24);
        //商户正则-25疗养场所
        Pattern patternCategory25 = Pattern.compile("体育休闲服务;度假疗养场所;");
        patternCategorySh.add(patternCategory25);
        //商户正则-26驾校
        Pattern patternCategory26 = Pattern.compile("科教文化服务;驾校;驾校");
        patternCategorySh.add(patternCategory26);
        //商户正则-27影剧院
        Pattern patternCategory27 = Pattern.compile("体育休闲服务;影剧院;");
        patternCategorySh.add(patternCategory27);
        //商户正则-28婴幼儿
        Pattern patternCategory28 = Pattern.compile("生活服务;婴儿服务场所;");
        patternCategorySh.add(patternCategory28);
        //商户正则-29文化生活
        Pattern patternCategory29 = Pattern.compile("科教文化服务;文艺团体;文艺团体|科教文化服务;图书馆;|科教文化服务;美术馆;|科教文化服务;博物馆;|科教文化服务;科技馆;科技馆|科教文化服务;天文馆;|科教文化服务;科教文化场所;科教文化场所|科教文化服务;文化宫;文化宫");
        patternCategorySh.add(patternCategory29);
        //商户正则-30礼品饰品
        Pattern patternCategory30 = Pattern.compile("购物服务;专卖店;礼品饰品店|购物服务;专卖店;礼品饰品店|购物服务|购物服务;专卖店;珠宝首饰工艺品|购物服务;专卖店;珠宝首饰工艺品|购物服务;专卖店;珠宝首饰工艺品|生活服务");
        patternCategorySh.add(patternCategory30);
        //商户正则-31农副产品市场
        Pattern patternCategory31 = Pattern.compile("购物服务;综合市场;农副产品市场|购物服务;综合市场;农副产品市场|餐饮服务|购物服务;综合市场;农副产品市场|公司企业|购物服务;综合市场;农副产品市场|购物服务|购物服务;综合市场;蔬菜市场|购物服务;综合市场;水产海鲜市场|购物服务;综合市场;水产海鲜市场|购物服务");
        patternCategorySh.add(patternCategory31);


        boolean villageFlag = false;//是小区吗？
        boolean wyFlag = false;//是物业吗？
        boolean totalShFlag = false;//商户吗？
        boolean[] shFlag = {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
        };//商户具体分类

        //遍历文件夹

//        List<FileModel> fileModelList = queryAllFileName("E:\\doc-hw-project\\from_jjp\\poi_amap_csv");
//        for (FileModel fileModel : fileModelList) {
//            if (!fileModel.isDirectory()) { //todo:-1
//                System.out.println(fileModel.getFileNmae());

        List<Long> errNoList = new ArrayList<Long>(1000000);//错误序号列表
        List<CommunityTenement> communityTenementList = new ArrayList<CommunityTenement>(1000000);//物业待插入列表
        List<CommunityVillage> communityVillageList = new ArrayList<CommunityVillage>(1000000);//小区待插入列表
        List<CommunityShop> communityShopList = new ArrayList<CommunityShop>(1000000);//商铺待插入列表
        List<Long> disNoList = new ArrayList<Long>(1000000);//抛弃序号List

//                File file = new File(fileModel.getFileNmae());
        File file = new File("E:\\doc-hw-project\\from_jjp\\poi_amap_csv\\上海市\\上海市市辖区.csv");
//        File file = new File("E:\\doc-hw-project\\from_jjp\\poi_amap_csv\\上海市\\上海异常数据修正.csv");
//        File file = new File("E:\\doc-hw-project\\from_jjp\\poi_amap_csv\\江苏省\\苏州市.csv");
//        File file = new File("E:\\doc-hw-project\\from_jjp\\poi_amap_csv\\江苏省\\苏州异常数据处理.csv");
        final Reader reader = new InputStreamReader(new FileInputStream(file), "GBK");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(reader);

        Long lineNo = 0L;//行号
        for (CSVRecord record : records) {
            ++lineNo;
            checkFlag = true;
            villageFlag = false;
            wyFlag = false;
            totalShFlag = false;
            shFlag = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };
            String longitude = record.get(1);
            String latitude = record.get(2);
            String colName = record.get(3);
            String address = record.get(4);
            String tel = record.get(5);
            String category = record.get(6);
            String zip = record.get(7);

//            System.out.println("经度：" + " " + longitude);
//            System.out.println("纬度：" + " " + latitude);
//            System.out.println("名称：" + " " + villageName);
//            System.out.println("地址：" + " " + address);
//            System.out.println("电话：" + " " + tel);
//            System.out.println("分类：" + " " + category);
//            System.out.println("邮编：" + " " + zip);

            //数据校验：
            //邮政编码校验
            if (patternZip.matcher(zip).find()) {
            } else {
                checkFlag = false;
            }

            if (!checkFlag) {
                errNoList.add(lineNo);
                continue;
            }

            //分类：
            if (patternCategoryWy.matcher(category).find() && patternNameWy.matcher(colName).find()) {//物业校验
                wyFlag = true;
            } else if (patternCategoryVillage.matcher(category).find()) {//小区校验
                villageFlag = true;
            } else {//商铺校验：
                int size = patternCategorySh.size();
                for (int i = 0; i < size && !totalShFlag; i++) {
                    Pattern patternCategory = patternCategorySh.get(i);
                    if (patternCategory.matcher(category).find()) {
                        if (5 == i) {
                            if (patternNameSh.get(0).matcher(colName).find()) {
                                shFlag[i] = true;
                                totalShFlag = true;
                                break;
                            }
                        } else if (6 == i) {
                            if (patternNameSh.get(1).matcher(colName).find()) {
                                shFlag[i] = true;
                                totalShFlag = true;
                                break;
                            }
                        } else if (8 == i) {
                            if (patternNameSh.get(2).matcher(colName).find()) {
                                shFlag[i] = true;
                                totalShFlag = true;
                                break;
                            }
                        } else if (9 == i) {
                            if (patternNameSh.get(3).matcher(colName).find()) {
                                shFlag[i] = true;
                                totalShFlag = true;
                                break;
                            }
                        } else if (14 == i) {
                            if (patternNameSh.get(4).matcher(colName).find()) {
                                shFlag[i] = true;
                                totalShFlag = true;
                                break;
                            }
                        } else {
                            shFlag[i] = true;
                            totalShFlag = true;
                        }
                    }
                }
            }


            if (wyFlag) {//归拢物业
                CommunityTenement communityTenement = new CommunityTenement();
                communityTenement.setLatitude(Double.parseDouble(latitude));
                communityTenement.setLongitude(Double.parseDouble(longitude));
                communityTenement.setName(colName);
                communityTenement.setAddress(address);
                communityTenementList.add(communityTenement);
            } else if (villageFlag) { //归拢小区
                CommunityVillage communityVillage = new CommunityVillage();
                communityVillage.setLatitude(Double.parseDouble(latitude));
                communityVillage.setLongitude(Double.parseDouble(longitude));
                communityVillage.setVillageName(colName);
                communityVillage.setAddress(address);

                communityVillageList.add(communityVillage);

            } else if (totalShFlag) {//归拢商铺

                CommunityShop communityShop = new CommunityShop();
                communityShop.setLatitude(Double.parseDouble(latitude));
                communityShop.setLongitude(Double.parseDouble(longitude));
                communityShop.setName(colName);
                communityShop.setAddress(address);
                //商铺类型
                int ii;
                for (ii = 0; ii < shFlag.length; ii++) {
                    if (shFlag[ii]) {
                        break;
                    }
                }
                communityShop.setType(convertMap.get(ii));
                communityShopList.add(communityShop);

            } else { //未归拢的
                disNoList.add(lineNo);
            }
        }

        //插入物业
        int count = 0;
        for (CommunityTenement communityTenement : communityTenementList) {
            ++count;
            try {
                stmtWy.setString(1, communityTenement.getName());
                stmtWy.setDouble(2, communityTenement.getLongitude());
                stmtWy.setDouble(3, communityTenement.getLatitude());
                stmtWy.setString(4, communityTenement.getAddress());
                stmtWy.executeUpdate();

                if (count % 10 == 0) {
                    con.commit();
                }
            } catch (SQLException e) {
                con.rollback();
            }
        }
        con.commit();

        //插入小区
        count = 0;
        for (CommunityVillage communityVillage : communityVillageList) {
            ++count;
            try {
                stmtVillage.setString(1, communityVillage.getVillageName());
                stmtVillage.setDouble(2, communityVillage.getLongitude());
                stmtVillage.setDouble(3, communityVillage.getLatitude());
                stmtVillage.setString(4, communityVillage.getAddress());
                stmtVillage.executeUpdate();

                if (count % 10 == 0) {
                    con.commit();
                }
            } catch (SQLException e) {
                con.rollback();
            }
        }
        con.commit();

        //插入商户
        count = 0;
        for (CommunityShop communityShop : communityShopList) {
            ++count;
            try {
                stmtSh.setString(1, communityShop.getName());
                stmtSh.setDouble(2, communityShop.getLongitude());
                stmtSh.setDouble(3, communityShop.getLatitude());
                stmtSh.setString(4, communityShop.getAddress());
                if (communityShop.getType() != null) {
                    stmtSh.setLong(5, communityShop.getType());
                } else {
                    System.out.println("null types");
                }
                stmtSh.executeUpdate();

                if (count % 10 == 0) {
                    con.commit();
                }
            } catch (SQLException e) {
                con.rollback();
            }
        }
        con.commit();

        // TODO:写入文件错误：
        BufferedWriter out = null;
        BufferedWriter out2 = null;
        try {
            out = new BufferedWriter(new FileWriter(file.getParent() + "\\checkError.txt", true));
            out2 = new BufferedWriter(new FileWriter(file.getParent() + "\\disError.txt", true));
            out.write("校验不过的行号：\n总数：" + errNoList.size() + "\n");
            out2.write("丢弃的行号：\n总数：" + disNoList.size() + "\n");
            int lineOut = 0;
            for (Long errNo : errNoList) {
                ++lineOut;
                out.write(errNo + ",");
                if (lineOut % 10 == 0) {
                    out.write("\n");
                }
            }
            lineOut = 0;
            for (Long disNo : disNoList) {
                ++lineOut;
                out2.write(disNo + ",");
                if (lineOut % 10 == 0) {
                    out2.write("\n");
                }
            }
        } catch (IOException e) {
            // error processing code
        } finally {
            if (out != null) {
                out.close();
            }
            if (out2 != null) {
                out2.close();
            }
        }


        //输出错误
//        System.out.print("校验不过的行号：");
//        int lineOut = 0;
//        for (Long errNo : errNoList) {
//            ++lineOut;
//            System.out.print(errNo + ",");
//            if (lineOut % 50 == 0) {
//                System.out.println();
//            }
//        }
//        System.out.println();
//        System.out.print("丢弃的行号：");
//        lineOut = 0;
//        for (Long disNo : disNoList) {
//            ++lineOut;
//            System.out.print(disNo + ",");
//            if (lineOut % 50 == 0) {
//                System.out.println();
//            }
//        }
//        System.out.println();
//            }//todo:-1
//        }

        //最后断开DB连接：
        if (stmtWy != null && !stmtWy.isClosed()) {
            try {
                stmtWy.close();
            } catch (SQLException iqnore) {

            }
        }
        if (stmtVillage != null && !stmtVillage.isClosed()) {
            try {
                stmtVillage.close();
            } catch (SQLException iqnore) {

            }
        }
        if (stmtSh != null && !stmtSh.isClosed()) {
            try {
                stmtSh.close();
            } catch (SQLException iqnore) {

            }
        }
        if (con != null && !con.isClosed()) {
            try {
                con.close();
            } catch (SQLException iqnore) {

            }
        }
    }

    static class FileModel {
        // 是否为文件夹
        private boolean isDirectory;

        // 文件名
        private String fileNmae;

        public FileModel(boolean isDirectory, String fileNmae) {
            super();
            this.isDirectory = isDirectory;
            this.fileNmae = fileNmae;
        }

        public boolean isDirectory() {
            return isDirectory;
        }

        public void setDirectory(boolean isDirectory) {
            this.isDirectory = isDirectory;
        }

        public String getFileNmae() {
            return fileNmae;
        }

        public void setFileNmae(String fileNmae) {
            this.fileNmae = fileNmae;
        }
    }
}