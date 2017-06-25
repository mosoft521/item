package alvintest;

/**
 * 插入--JDBC例子
 * <p>
 * Created by 001620 on 2014/9/19.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcAlvin001 {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost/test";
        String user = "root";
        String pass = "";

        User[] users = {new User("user01", "user01@example.com"),
                new User("user02", "user02@example.com"),
                new User("user03", "user03@example.com"),
                new User("user04", "user04@example.com"),
                new User("user05", "user05@example.com")};

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = DriverManager.getConnection(url, user, pass);
            stmt = con
                    .prepareStatement("insert into user (name, email) values (? , ?)");

            con.setAutoCommit(false);

            for (User u : users) {
                stmt.setString(1, u.name);
                stmt.setString(2, u.email);
                stmt.executeUpdate();

            }

            con.commit();
        } catch (SQLException e) {
            con.rollback();
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