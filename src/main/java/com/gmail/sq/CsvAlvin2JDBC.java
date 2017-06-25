package com.gmail.sq;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 001620 on 2014/9/27.
 */
public class CsvAlvin2JDBC {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://172.16.10.79/hw-sq-alvin?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useLocalSessionState=true";
        String user = "shequ_dev";
        String pass = "904";

        Connection con = null;
        PreparedStatement stmt = null;
        BufferedWriter out = null;

        try {
            con = DriverManager.getConnection(url, user, pass);
            stmt = con.prepareStatement("select longitude,latitude,mobile,phone,tel_all from community_shop_tmp where tel_all is not null");
            ResultSet rs = stmt.executeQuery();
            out = new BufferedWriter(new FileWriter("E:\\update_community_shop.sql", true));

            int count = 0;
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                ++count;
                sb.delete(0, sb.length());
                double longitude = rs.getDouble("longitude");
                double latitude = rs.getDouble("latitude");
                String mobile = rs.getString("mobile");
                String phone = rs.getString("phone");
                String tel_all = rs.getString("tel_all");

                sb.append("update community_shop set mobile=");
                if (StringUtils.isBlank(mobile)) {
                    sb.append("null");
                } else {
                    sb.append("'").append(mobile).append("'");
                }
                sb.append(",phone=");
                if (StringUtils.isBlank(phone)) {
                    sb.append("null");
                } else {
                    sb.append("'").append(phone).append("'");
                }
                sb.append(",tel_all=");
                if (StringUtils.isBlank(tel_all)) {
                    sb.append("null");
                } else {
                    sb.append("'").append(tel_all).append("'");
                }
                sb.append(" where longitude=").append(longitude).append(" and latitude=").append(latitude).append(";\n");
                out.write(sb.toString());
            }
            System.out.println("行数：" + count);

        } finally {
            if (stmt != null && !stmt.isClosed()) {
                try {
                    stmt.close();
                } catch (SQLException iqnore) {

                }
            }
            if (con != null && !con.isClosed()) {
                try {
                    con.close();
                } catch (SQLException iqnore) {

                }
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
