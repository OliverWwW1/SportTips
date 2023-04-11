package com.example.sporttips.Database;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbOpenHelper {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String ip = "192.168.20.106";  // 安装了 mysql 的电脑的 ip 地址
    private static String dbName = "sporttips";    // 要连接的数据库
    private static String user = "root";    // 用户名
    private static String password = "123456"; // 密码
    private static Connection sConnection = null;
    private static Context context;

    private static int port = 3306;

    public static Connection getConnection(String ip) {
      try {
          String url = "jdbc:mysql://" + ip + ":" + port
                  + "/" + dbName+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            Class.forName(driver);
            sConnection = DriverManager.getConnection(url, user, password);;//获取连接
          Log.i("test","连接成功");
        } catch (ClassNotFoundException e) {
          sConnection = null;
            e.printStackTrace();
        } catch (SQLException e) {
          sConnection = null;
            e.printStackTrace();
        }
        return sConnection;
    }

    public static void closeConnection() {
        if (sConnection != null) {
            try {
                sConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}