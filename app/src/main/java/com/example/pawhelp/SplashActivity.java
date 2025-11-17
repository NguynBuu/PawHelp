package com.example.pawhelp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler; // Cần import Handler
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;

public class SplashActivity extends AppCompatActivity {

    // 3 giây = 3000 milliseconds
    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        // --- BẮT ĐẦU LOGIC HẸN GIỜ ---
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Tạo Intent để chuyển màn hình
                Intent i = new Intent(SplashActivity.this, WelcomeActivity.class);
                startActivity(i);

                // Kết thúc Splash Activity
                finish();
            }
        }, SPLASH_TIME_OUT);
        // --- KẾT THÚC LOGIC HẸN GIỜ ---
    }
}