package com.example.pawhelp;

import android.os.StrictMode;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    // !!! BẠN PHẢI THAY THẾ CÁC GIÁ TRỊ SAU BẰNG THÔNG TIN CỦA MÁY CHỦ SQL SERVER CỦA BẠN !!!
    // IP này phải là IP Public hoặc IP nội bộ nếu bạn đang chạy Emulator/thiết bị cùng mạng
    private static final String IP = "ĐIỀN_IP_MÁY_CHỦ_CỦA_BẠN_VÀO_ĐÂY";
    private static final String DB = "PawHelpDB";
    private static final String USER = "ĐIỀN_TÊN_NGƯỜI_DÙNG_CSDL_VÀO_ĐÂY";
    private static final String PASS = "ĐIỀN_MẬT_KHẨU_CSDL_VÀO_ĐÂY";

    // Tên Class Driver chính xác cho Microsoft JDBC
    private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    // Chuỗi URL kết nối sử dụng Microsoft JDBC
    private static final String DB_URL = "jdbc:sqlserver://" + IP + ":1433;databaseName=" + DB + ";user=" + USER + ";password=" + PASS + ";encrypt=false;trustServerCertificate=true;";

    public Connection connection;

    public DBConnect() {
        // Cho phép các hoạt động mạng trên Main Thread (CHỈ DÙNG KHI TEST)
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            // Load driver class (Bắt buộc cho Android)
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            Log.e("DBConnect", "Lỗi Driver Class: Không tìm thấy SQLServerDriver. Đảm bảo file JAR đã được thêm đúng.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Log.d("DBConnect", "Đang cố gắng kết nối tới: " + IP);
            connection = DriverManager.getConnection(DB_URL);
            Log.d("DBConnect", "Kết nối CSDL thành công!");

        } catch (SQLException e) {
            // Lỗi kết nối, bao gồm lỗi sai IP/User/Pass
            Log.e("DBConnect", "LỖI KẾT NỐI CSDL: " + e.getMessage());
            // In chi tiết lỗi để debug (ví dụ: Lỗi cổng 1433, Lỗi chứng chỉ, Lỗi đăng nhập)
            e.printStackTrace();
            connection = null;
        } catch (Exception e) {
            Log.e("DBConnect", "Lỗi không xác định: " + e.getMessage());
            e.printStackTrace();
            connection = null;
        }
        return connection;
    }
}