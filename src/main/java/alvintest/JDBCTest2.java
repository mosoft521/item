package alvintest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by 001620 on 2014/9/19.
 */
public class JDBCTest2 {
    /*连接和建立数据库和股票数据表gubiao
     * */
    public static void main(String args[]) {
        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //驱动
        String URL = "jdbc:sqlserver://localhost:1433;DataBaseName=3070421090";

        final String NAME = "sa"; //数据库登录账号
        final String PASS = "";


        try {
            Class.forName(DRIVER); //注册驱动
            //获取连接字符串
            Connection conn = DriverManager.getConnection(URL, NAME, PASS);
            Statement s = conn.createStatement();
            String query = "create  table gubiao(date datatime,open float,high float,low float,close float,amount integer,money float)";//创建数据库属性
            s.executeUpdate(query);
            s.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("format" + e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "获取连接字符串错误");

        } catch (Exception e) {
            System.out.println("SQLException;" + e.getMessage());
        }
    }


    /*插入某条数据
     * */
    public static void main2(String args[]) {

        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //驱动
        String URL = "jdbc:sqlserver://localhost:1433;DataBaseName=3070421090";

        final String NAME = "sa"; //数据库登录账号
        final String PASS = "";

        try {

            Class.forName(DRIVER); //注册驱动
            //获取连接字符串
        } catch (java.lang.ClassNotFoundException e) {

            System.out.println("forname;" + e.getMessage());

        }
        try {

            Connection conn = DriverManager.getConnection(URL, NAME, PASS);

            Statement s = conn.createStatement();

            String r1 = "insert  into gubiao value()";//在股票数据库表中插入数据

            s.executeUpdate(r1);

            s.close();

            conn.close();
        } catch (SQLException e) {

            System.out.println("SQLException;" + e.getMessage());
        }

    }

    /*修改某条数据并把数据表的内容显示到屏幕上
     * */
    public static void main3(String args[]) {

        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //驱动
        String URL = "jdbc:sqlserver://localhost:1433;DataBaseName=3070421090";
        String[] zeh = {"主码"};//输入证劵的代码号
        float[] money = {(float) 133445.9};//输入需要修改的数据
        final String NAME = "sa"; //数据库登录账号
        final String PASS = "";

        try {

            Class.forName(DRIVER); //注册驱动
            //获取连接字符串
        } catch (java.lang.ClassNotFoundException e) {

            System.out.println("forname;" + e.getMessage());

        }
        try {
            Connection conn = DriverManager.getConnection(URL, NAME, PASS);
            PreparedStatement ps = conn.prepareStatement("UPDATE  gubiao  set money=? where  zeh =?");
            int i = 0, zehlen = zeh.length;
            do {
                ps.setDouble(1, money[i]);
                ps.setString(2, zeh[i]);
                ps.executeUpdate();
                i++;
            } while (i < zeh.length);
            ps.close();
            //查询数据库并把数据表的内容输出到屏幕上
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from  gubiao");
            while (rs.next()) {
                System.out.println(rs.getString("") + "\t" + rs.getString("") + "\t" + rs.getString("") + "\t" + rs.getString("") + "\t" + rs.getString("") + "\t" + rs.getString("") + "\t" + rs.getString("") + "\t" + rs.getString(""));
                //输出该行数据
            }
            s.close();
            conn.close();
        } catch (SQLException e) {

            System.out.println("SQLException;" + e.getMessage());
        }
    }
}

