package com.gmail.sq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.fluent.Request;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 001620 on 2014/9/23.
 */
public class Point2PCA {

    private static Map<String, PCA> map;

    public static void main(String[] args) throws Exception {
        map = pcaMap();
        parseVillage();
    }

    public static void parseVillage() throws Exception {
        String jdbc_url = "jdbc:mysql://172.16.10.79:3306/hw-sq", userName = "shequ_dev", password = "904";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("数据库驱动加载失败!");
        }
        Connection conn = null;
        StringBuilder text = new StringBuilder();
        try {
            conn = DriverManager.getConnection(jdbc_url, userName, password);
            conn.setAutoCommit(false);
            String query_sql = "SELECT village_id vid,longitude lng,latitude lat FROM community_village";
            PreparedStatement prest = conn.prepareStatement(query_sql);
            String update_sql = "update community_village set province_id = '%s',city_id = '%s', district_id = '%s' where village_id = '%s';\r\n";
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                String area = gaode(rs.getString("lng"), rs.getString("lat"));
                PCA p = map.get(area);
                text.append(String.format(update_sql, new String[]{p.getPrivince(), p.getCity(), p.getArea(), rs.getString("vid")}));
            }
            conn.commit();
            rs.close();
            prest.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        //写入文件
        FileWriter writer = new FileWriter(new File("F:/高德小区.sql"));
        writer.write(text.toString());
        writer.close();
    }

    public static String gaode(String lng, String lat) throws Exception {
        String url = "http://search1.mapabc.com/sisserver?highLight=true&config=SPAS&ver=2.0&resType=json&enc=utf-8&spatialXml=" +
                "%3C?xml%20version=%221.0%22%20encoding=%22gb2312%22?%3E%3Cspatial_request%20" +
                "method=%22searchPoint%22%3E%3Cx%3E" +
                lng +
                "%3C/x%3E%3Cy%3E" +
                lat +
                "%3C/y%3E%3Cxs%3E%3C/xs%3E%3Cys%3E%3C/ys%3E" +
                "%3CpoiNumber%3E30%3C/poiNumber%3E%3Crange%3E3000%3C/range%3E%3Cpattern%3E1%3C/pattern%3E%3CroadLevel%3E0%3C/roadLevel%3E%3C/spatial_request%3E&" +
                "a_k=b0a7db0b3a30f944a21c3682064dc70ef5b738b062f6479a5eca39725798b1ee300bd8d5de3a4ae3&ctx=1772822";
        String data = Request.Get(url).execute().returnContent().asString();
        data = data.substring(data.indexOf("{")).replace(")", "");
        JSONObject json = JSON.parseObject(data);
        String area = json.getJSONObject("SpatialBean").getJSONObject("District").getString("code");
        return area;
    }

    public static Map<String, PCA> pcaMap() throws Exception {
        Map<String, PCA> map = new HashMap<String, PCA>();
        String jdbc_url = "jdbc:mysql://172.16.10.79:3306/hw-sq", userName = "shequ_dev", password = "904";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("数据库驱动加载失败!");
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbc_url, userName, password);
            conn.setAutoCommit(false);
            String query_sql = "SELECT sys_province.province_name, sys_province.province_id provinceId, a.city_name, a.city_id cityId, " +
                    "a.area_name, a.area_id areaId FROM sys_province INNER JOIN ( SELECT sys_area.area_id, city_name, area_name, " +
                    "province_id, sys_area.city_id FROM sys_area INNER JOIN sys_city ON sys_area.city_id = sys_city.id_card_code) a " +
                    "ON sys_province.province_id = a.province_id";
            PreparedStatement prest = conn.prepareStatement(query_sql);
            ResultSet rs = prest.executeQuery();
            PCA pca;
            while (rs.next()) {
                String areaId = rs.getString("areaId");
                pca = new PCA(rs.getString("provinceId"), rs.getString("cityId"), areaId);
                map.put(areaId, pca);
            }
            conn.commit();
            rs.close();
            prest.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return map;
    }

    static class PCA {

        private String privince;
        private String city;
        private String area;

        PCA() {
        }

        PCA(String privince, String city, String area) {
            this.privince = privince;
            this.city = city;
            this.area = area;
        }

        public String getPrivince() {
            return privince;
        }

        public void setPrivince(String privince) {
            this.privince = privince;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }
    }
}
