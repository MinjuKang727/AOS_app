package com.example.ex220926;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Color_Activity extends AppCompatActivity {
//    0. 각 View 초기화
//    1. btnHome 버튼 눌렀을 때,
//    2. etColor에서 문자열 가져와서
//    3. String color에 대입!!

    EditText et_color;
    Button btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        et_color = findViewById(R.id.et_color);
        btn_home = findViewById(R.id.btn_home);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String color = et_color.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("color", color);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}