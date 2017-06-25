package com.gmail.sq;

import com.gmail.core.util.Pinyin4jUtil;

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
public class Pinyin4JMysql {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://172.16.10.79/hw-sq-alvin?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useLocalSessionState=true";
        String user = "shequ_dev";
        String pass = "904";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        con = DriverManager.getConnection(url, user, pass);
        PreparedStatement stmtQuery = null;
        PreparedStatement stmtUpdate = null;
        stmtQuery = con.prepareStatement("select * from community_village");
        stmtUpdate = con.prepareStatement("update community_village set pinyin=? where village_id=?");


        Map<Long, String> nameMap = new HashMap<Long, String>();

        ResultSet rs = stmtQuery.executeQuery();

        while (rs.next()) {
            Long id = rs.getLong("village_id");
            String name = rs.getString("village_name");
            nameMap.put(id, name);
        }
        con.setAutoCommit(false);
        int count = 0;
        for (Map.Entry<Long, String> entry : nameMap.entrySet()) {
            ++count;
            try {
                String name = entry.getValue();
                String pinyin = Pinyin4jUtil.getPinyin(name).iterator().next();
                stmtUpdate.setString(1, pinyin);
                stmtUpdate.setLong(2, entry.getKey());
                stmtUpdate.executeUpdate();
                if (count % 10 == 0) {
                    con.commit();
                }
            } catch (SQLException e) {
                con.rollback();
            }
        }
        con.commit();

        if (stmtQuery != null && !stmtQuery.isClosed()) {
            try {
                stmtQuery.close();
            } catch (SQLException iqnore) {

            }
        }
        if (stmtUpdate != null && !stmtUpdate.isClosed()) {
            try {
                stmtUpdate.close();
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
}
