package cn.panjin.shenxianbms.application.multithreading.component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <p>
 * ThreadLocal在申明式事务中的运用示例
 * </p>
 *
 * @Anthor panjin
 * @Description
 * @Date 2020/1/13 0013 19:53
 * @Version 1.0
 */
public class TransactionHelper {
    //使用ThreadLocal持有当前线程的数据库连接
    private final static ThreadLocal<Connection> connection_holder = new ThreadLocal<Connection>();

    //连接配置，来自connection.properties
    private final static Properties connectionProp = new Properties();

    static {
        //加载配置文件
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("connection.properties");
        try {
            connectionProp.load(is);
            is.close();
            //加载驱动程序
            Class.forName(connectionProp.getProperty("driverClassName"));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("驱动未找到", e);
        }
    }

    //获取当前线程中的数据库连接
    private static Connection getCurrentConnection() {
        Connection conn = connection_holder.get();
        if (conn == null) {
            conn = createNotAutoCommitConnection();
            connection_holder.set(conn);
        }
        return conn;
    }

    //执行SQL语句
    public static int executeNonQuery(String sql) throws SQLException {
        Connection conn = getCurrentConnection();
        return conn.createStatement().executeUpdate(sql);
    }

    //提交事务
    public static void commit() {
        Connection conn = getCurrentConnection();
        try {
            conn.commit();
            conn.close();
            connection_holder.set(null);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    //回滚事务
    public static void rollback() {
        Connection conn = getCurrentConnection();
        try {
            conn.rollback();
            conn.close();
            connection_holder.set(null);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    //创建一个不自动Commit的数据库连接
    private static Connection createNotAutoCommitConnection() {
        try {
            Connection conn = DriverManager.getConnection(connectionProp.getProperty("url")
                    + ";databaseName=" + connectionProp.getProperty("databaseName")
                    , connectionProp.getProperty("username")
                    , connectionProp.getProperty("password"));
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
