package com.example.pawhelp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class TeamActivity extends AppCompatActivity {

    private ImageView ivBack;
    private EditText etSearch;
    private RecyclerView recyclerViewTeam;
    private FloatingActionButton fabChat;
    private TeamAdapter teamAdapter;
    private List<TeamMember> teamMembers;
    private List<TeamMember> filteredMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        initViews();
        setupRecyclerView();
        setupListeners();
        setupSearch();
    }

    private void initViews() {
        ivBack = findViewById(R.id.ivBack);
        etSearch = findViewById(R.id.etSearch);
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
                R.drawable.ic_avatar_placeholder
        ));
        teamMembers.add(new TeamMember(
                "Nguyễn Thanh Hiền",
                "Quản lý dự án",
                "Hành trình trở thành tình nguyện viên của DPT vào năm 2020 với sứ mệnh",
                "TRỢ LÝ ĐỘI TRƯỞNG",
                R.drawable.ic_avatar_placeholder
        ));
        teamMembers.add(new TeamMember(
                "Phạm Hồng Hạnh",
                "Tình nguyện viên",
                "Chuyên viên chăm sóc và bảo vệ động vật",
                "THÀNH VIÊN",
                R.drawable.ic_avatar_placeholder
        ));

        filteredMembers = new ArrayList<>(teamMembers);
        teamAdapter = new TeamAdapter(this, filteredMembers);
        recyclerViewTeam.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTeam.setAdapter(teamAdapter);
    }

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterMembers(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void filterMembers(String query) {
        filteredMembers.clear();

        if (query.isEmpty()) {
            filteredMembers.addAll(teamMembers);
        } else {
            String lowerQuery = query.toLowerCase();
            for (TeamMember member : teamMembers) {
                if (member.getName().toLowerCase().contains(lowerQuery) ||
                    member.getPosition().toLowerCase().contains(lowerQuery)) {
                    filteredMembers.add(member);
                }
            }
        }

        teamAdapter.notifyDataSetChanged();
    }

    private void setupListeners() {
        ivBack.setOnClickListener(v -> finish());

        fabChat.setOnClickListener(v -> {
            // Xử lý chat
        });
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
