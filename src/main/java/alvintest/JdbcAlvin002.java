package alvintest;

/**
 * 读取--JDBC例子
 * Created by 001620 on 2014/9/19.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcAlvin002 {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost/test";
        String user = "root";
        String pass = "admin";

        User[] users = {
                new User("user01", "user01@example.com"),
                new User("user02", "user02@example.com"),
                new User("user03", "user03@example.com"),
                new User("user04", "user04@example.com"),
                new User("user05", "user05@example.com")
        };

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = DriverManager.getConnection(url, user, pass);
            stmt = con.prepareStatement("select * from user");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println(id + ":" + name + ":" + email);
            }

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
        }
    }

    static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

    }
}