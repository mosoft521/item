package alvintest;

//import com.ctl.bean.Person;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Administrator
 * @category
 */
public class DButils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static Connection conn;
    private static ThreadLocal<Connection> connHolder = new ThreadLocal<Connection>();

    static {
//        driver = ConfigUtils.getType("mysql.driver");
//        url = ConfigUtils.getType("mysql.url");
//        username = ConfigUtils.getType("mysql.username");
//        password = ConfigUtils.getType("mysql.password");
//        try {
//            Runtime.getRuntime().exec("net start mysql");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * @return Connection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException,
            ClassNotFoundException {
        conn = connHolder.get();
        if (conn == null || conn.isClosed()) {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
            connHolder.set(conn);
        }
        return conn;
    }

    /**
     * @param sql
     * @return 如果返回-1代表出错
     * @category 根据sql得到记录总数
     */
    public static int getCount(String sql) {
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;

    }

    /**
     * @throws SQLException
     * @category close Connection
     */
    public static void close() throws SQLException {
        conn.close();
        connHolder.set(null);
    }

    public static int createTable(Class c) {
        String tableName = c.getSimpleName().toLowerCase();// person
        return 0;

    }

    /*
     * public static void insertEntity(Class c, Object o) {
     * System.out.println(o); Object fileds[] = o.toString().split("__"); int
     * fieldSize = fileds.length; System.out.println(fieldSize); String
     * tableName = c.getSimpleName().toLowerCase();// person // String
     * className=c.getSimpleName();//Person int bookIsExis = getCount(
     * "SELECT count(table_name) FROM information_schema.TABLES WHERE table_name='"
     * + tableName + "' "); if (bookIsExis < 1) { System.out.println("表不存在");
     * return; } StringBuffer sql = new StringBuffer("insert into " + tableName
     * + " values("); for (int i = 0; i < fieldSize; i++) { sql.append("?,"); }
     * sql.deleteCharAt(sql.length() - 1); sql.append(")");
     * System.out.println(sql); PreparedStatement ps; try { ps =
     * getConnection().prepareStatement(sql.toString()); for (int i = 0; i <
     * fieldSize; i++) { if (fileds[i] != null && !"".equals(fileds[i]) &&
     * !"null".equals(fileds[i])) { ps.setObject(i + 1, fileds[i]); } else {
     * ps.setObject(i + 1, null); } } ps.executeUpdate();
     * getConnection().commit(); } catch (Exception e) { e.printStackTrace(); }
     *
     * }
     */
    public static void insertEntity(Class c, Object obj) {
        // System.out.println("1");
        if (obj == null || c.getSimpleName().equals(obj.getClass().getName()))
            return;
        Field[] fields = obj.getClass().getDeclaredFields();
        int fieldSize = fields.length;
        String tableName = c.getSimpleName().toLowerCase();// person
        String[] types1 = {"int", "java.lang.String", "boolean", "char",
                "float", "double", "long", "short", "byte"};
        String[] types2 = {"Integer", "java.lang.String", "java.lang.Boolean",
                "java.lang.Character", "java.lang.Float", "java.lang.Double",
                "java.lang.Long", "java.lang.Short", "java.lang.Byte"};

        StringBuffer sql = new StringBuffer("insert into " + tableName
                + " values(");
        for (int i = 0; i < fieldSize; i++) {
            sql.append("?,");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        System.out.println(sql);
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement(sql.toString());
            for (int j = 0; j < fieldSize; j++) {
                fields[j].setAccessible(true);
                for (int i = 0; i < types1.length; i++) {
                    if (fields[j].getType().getName()
                            .equalsIgnoreCase(types1[i])
                            || fields[j].getType().getName()
                            .equalsIgnoreCase(types2[i])) {

                        if (fields[j].get(obj) != null
                                && !"".equals(fields[j].get(obj))
                                && !"null".equals(fields[j].get(obj))) {
                            System.out.println(fields[j].get(obj) + " ");
                            ps.setObject(j + 1, fields[j].get(obj));
                        } else {
                            System.out.println(fields[j].get(obj) + " ");
                            ps.setObject(j + 1, null);
                        }
                    }
                }
            }
            System.out.println(ps.toString());
            ps.executeUpdate();
            getConnection().commit();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            DButils.getConnection();
            // System.out.println(getCount("SELECT count(table_name) FROM information_schema.TABLES WHERE table_name='book' "));
//            Person person = new Person();
//            person.setId(1);
//            person.setAddress("xin xiang");
//            insertEntity(Person.class, person);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}