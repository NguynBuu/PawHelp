package com.example.pawhelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText etFullName, etEmail, etPhone, etPassword, etConfirmPassword;
    private CheckBox cbReporter, cbRescuer;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Ánh xạ View
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        cbReporter = findViewById(R.id.cbReporter);
        cbRescuer = findViewById(R.id.cbRescuer);
        btnRegister = findViewById(R.id.btnRegister);

        // Đảm bảo chỉ chọn 1 trong 2 loại tài khoản
        cbReporter.setOnClickListener(v -> {
            if (cbReporter.isChecked()) cbRescuer.setChecked(false);
        });
        cbRescuer.setOnClickListener(v -> {
            if (cbRescuer.isChecked()) cbReporter.setChecked(false);
        });

        // --- LOGIC ĐĂNG KÝ TĨNH ---
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kiểm tra đầu vào cơ bản (Validation)
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                if (password.isEmpty() || !password.equals(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Mật khẩu không hợp lệ hoặc không khớp!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // MÔ PHỎNG ĐĂNG KÝ THÀNH CÔNG:
                Toast.makeText(RegisterActivity.this, "Đăng ký thành công! Vui lòng đăng nhập.", Toast.LENGTH_LONG).show();
                // Chuyển sang màn hình Đăng nhập
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Xử lý chuyển sang màn hình Đăng nhập (Tab Đăng nhập trong Header)
        findViewById(R.id.tab_login).setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Đóng Register để quay lại dễ dàng
        });
    }
}