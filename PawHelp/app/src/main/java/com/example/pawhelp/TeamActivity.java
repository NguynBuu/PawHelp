package com.example.pawhelp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class TeamActivity extends AppCompatActivity {

    private ImageView ivBack;
    private RecyclerView recyclerViewTeam;
    private FloatingActionButton fabChat;
    private TeamAdapter teamAdapter;
    private List<TeamMember> teamMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        initViews();
        setupRecyclerView();
        setupListeners();
    }

    private void initViews() {
        ivBack = findViewById(R.id.ivBack);
        recyclerViewTeam = findViewById(R.id.recyclerViewTeam);
        fabChat = findViewById(R.id.fabChat);
    }

    private void setupRecyclerView() {
        // Tạo dữ liệu mẫu
        teamMembers = new ArrayList<>();
        teamMembers.add(new TeamMember(
                "Phạm Khánh Quyên",
                "Nhà sáng lập",
                "• Chuyên gia cứu hộ\n• Trước khi sáng lập nên DANANG PETADOPTTEAM",
                "ĐÃ ĐĂNG KÝ",
                R.drawable.member1
        ));
        teamMembers.add(new TeamMember(
                "Nguyễn Thanh Hiền",
                "Quản lý dự án",
                "Hành trình trở thành tình nguyện viên của DPT vào năm 2020 với sứ mệnh",
                "TRỢ LÝ ĐỘI TRƯỞNG",
                R.drawable.member2
        ));
        teamMembers.add(new TeamMember(
                "Phạm Hồng Hạnh",
                "Tình nguyện viên",
                "Chuyên viên chăm sóc và bảo vệ động vật",
                "THÀNH VIÊN",
                R.drawable.member3
        ));

        teamAdapter = new TeamAdapter(this, teamMembers);
        recyclerViewTeam.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTeam.setAdapter(teamAdapter);
    }

    private void setupListeners() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fabChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý chat
            }
        });
    }
}
