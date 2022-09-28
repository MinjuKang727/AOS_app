package com.example.ex220926;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.reflect.Array;

public class Image_Activity extends AppCompatActivity {
    int index;  // 전역변수 : 어떠한 상황에도 만들어짐
    boolean isVisible;  // 변수명에 is가 붙으면 보통 boolean타입

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ImageView iv_pokemon = findViewById(R.id.iv_pokemon);
        Button btn_pre = findViewById(R.id.btn_pre);
        Button btn_next = findViewById(R.id.btn_next);
        Button btn_onoff = findViewById(R.id.btn_onoff);
        index = 0;
        isVisible = true;

//        상태가 2가지(보이기/안보이기) 일 때는 보통  Boolean타입 사용


//      lambda expression(java 1.8 이상)
//        장점 : 직관적, 간편하게 사용 가능
//        단점 : 안쪽 구조를 알 수 없음
//        new View.OnClickListener() {} 랑 v-> {}랑 동일한 역할
        btn_onoff.setOnClickListener(v -> {
            if (isVisible) {
                iv_pokemon.setVisibility(View.INVISIBLE);
                btn_onoff.setText("보이기");
            }else{
                iv_pokemon.setVisibility(View.VISIBLE);
                btn_onoff.setText("감추기");
            }
            isVisible = !isVisible;
        });
//        안쪽 매개변수가 2개일 경우
//        btn_onoff.setOnClickListener((v, c) -> {});

        int[] imgs = {R.drawable.img1,R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};

//         맨 처음 이미지 : img1 >> imgs[0]
//        "다음" 버튼 눌렀을 때, 출력되어야 하는 이미지 : imgs[1]

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                "다음"버튼 눌렀을 때, 동작하는 부분
                if (index == 4){
                    index = 0;
                }else{
                    index++;
                }
                iv_pokemon.setImageResource(imgs[index]);

            }
        });

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                "다음"버튼 눌렀을 때, 동작하는 부분
                if (index == 0){
                    index = 4;
                }else{
                    index--;
                }
                iv_pokemon.setImageResource(imgs[index]);

            }
        });
    }
}