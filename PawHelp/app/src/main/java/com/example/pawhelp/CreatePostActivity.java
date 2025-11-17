package com.example.pawhelp;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import java.util.ArrayList;
import java.util.List;

public class CreatePostActivity extends AppCompatActivity {

    private ImageView ivBack;
    private CardView cardUploadImage;
    private ImageView ivPreview;
    private Spinner spinnerCategory;
    private ChipGroup chipGroupTags;
    private EditText etTitle;
    private EditText etContent;
    private Button btnSubmit;

    private Uri selectedImageUri;
    private ActivityResultLauncher<String> imagePickerLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        initViews();
        setupCategorySpinner();
        setupImagePicker();
        setupListeners();
    }

    private void initViews() {
        ivBack = findViewById(R.id.ivBack);
        cardUploadImage = findViewById(R.id.cardUploadImage);
        ivPreview = findViewById(R.id.ivPreview);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        chipGroupTags = findViewById(R.id.chipGroupTags);
        etTitle = findViewById(R.id.etTitle);
        etContent = findViewById(R.id.etContent);
        btnSubmit = findViewById(R.id.btnSubmit);
    }

    private void setupCategorySpinner() {
        String[] categories = {
            "Chọn danh mục",
            "Câu chuyện cứu hộ",
            "Tìm nhà cho thú cưng",
            "Chia sẻ kinh nghiệm",
            "Thông tin hữu ích",
            "Sự kiện",
            "Khác"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_spinner_item,
            categories
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);
    }

    private void setupImagePicker() {
        imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        selectedImageUri = uri;
                        ivPreview.setImageURI(uri);
                        ivPreview.setVisibility(View.VISIBLE);
                    }
                });
    }

    private void setupListeners() {
        ivBack.setOnClickListener(v -> finish());

        cardUploadImage.setOnClickListener(v -> openImagePicker());

        btnSubmit.setOnClickListener(v -> submitPost());
    }

    private void openImagePicker() {
        imagePickerLauncher.launch("image/*");
    }

    private void submitPost() {
        String title = etTitle.getText().toString().trim();
        String content = etContent.getText().toString().trim();
        String category = spinnerCategory.getSelectedItem().toString();

        // Get selected tags
        List<String> selectedTags = new ArrayList<>();
        for (int i = 0; i < chipGroupTags.getChildCount(); i++) {
            Chip chip = (Chip) chipGroupTags.getChildAt(i);
            if (chip.isChecked()) {
                selectedTags.add(chip.getText().toString());
            }
        }

        if (category.equals("Chọn danh mục")) {
            Toast.makeText(this, "Vui lòng chọn danh mục", Toast.LENGTH_SHORT).show();
            return;
        }

        if (title.isEmpty()) {
            etTitle.setError("Vui lòng nhập tiêu đề");
            etTitle.requestFocus();
            return;
        }

        if (content.isEmpty()) {
            etContent.setError("Vui lòng nhập nội dung");
            etContent.requestFocus();
            return;
        }

        // TODO: Implement actual post submission logic
        Toast.makeText(this, "Đang đăng bài...", Toast.LENGTH_SHORT).show();

        // Simulate success
        Toast.makeText(this, "Đăng bài thành công!", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
