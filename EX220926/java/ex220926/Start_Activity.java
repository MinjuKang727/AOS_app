package com.example.ex220926;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Start_Activity extends AppCompatActivity {

//    전역 변수 부분(field)
    Button btn_end;
    EditText et_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

//        초기화(Initialize)란?
        int num = 5;
//        int num;  // 변수의 선언
//        num = 5;  // 변수의 할당 (최초의 할당 : 초기화)
//        num = 7;  //  변수 재할당




//       0. ID를 부여한 모든 View(Component)를 초기화
        btn_end = findViewById(R.id.btn_end);
        et_menu = findViewById(R.id.et_menu);

        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//          Activity -> Activity로 이동 (Activity간 이동)
//                Intent 객체 사용
//                Intent 사용법(2가지)
//                - 명시적 사용법
//                - 묵시적 사용법 : Intent intent = new Intent(출발Activity, 도착Activity);


//          1. etMenu를 초기화
//          2. "끝으로 이동" 버튼 눌렀을 때,
//             et_menu에 있는 문자열을 가져와서 String menu에 저장!!
//          3. "돈까스 대신에 문자열로 저장된 menu를 보내자!!

            String menu = et_menu.getText().toString();

//            단방향 데이터 이동 : 한쪽 데이터에서 한쪽 데이터로 (한쪽 방향으로만) 데이터 이동
                Intent intent = new Intent(Start_Activity.this, Finish_Activity.class);
                intent.putExtra("menu", menu);
                startActivity(intent);  // startActivity는 지금 이 파일명이 아니라 함수명!!

            }
        });

//        btn_end.setOnClickListener(view -> {
//
//        });
    }
}