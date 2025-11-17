package com.example.pawhelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button; // Cần import Button
import androidx.appcompat.app.AppCompatActivity;

// Xóa các import EdgeToEdge không cần thiết nếu không tùy chỉnh padding
import androidx.activity.EdgeToEdge;
import androidx.core.view.ViewCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {

    private Button btnLogin;      // Khai báo nút Đăng nhập
    private Button btnRegister;   // Khai báo nút Đăng ký

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);

        // --- BẮT ĐẦU ÁNH XẠ VÀ LOGIC CHUYỂN MÀN HÌNH ---

        // 1. Ánh xạ các nút từ Layout XML
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        // 2. Xử lý sự kiện: Nhấn Đăng nhập -> Chuyển sang LoginActivity
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // 3. Xử lý sự kiện: Nhấn Đăng ký tài khoản -> Chuyển sang RegisterActivity
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        // Giữ lại logic Edge-to-Edge nếu bạn muốn giữ lại phần code này (không bắt buộc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}