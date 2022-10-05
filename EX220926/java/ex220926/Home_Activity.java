package com.example.ex220926;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Activity extends AppCompatActivity {

    Button btn_color;
    final int COLOR = 5793;

//    상수 : 변하지 않는 수
//    상수 선언 키워드 :  final
//    상수 변수는 무조건 대문자로 선언!!
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_color = findViewById(R.id.btn_color);
        cl = findViewById(R.id.cl);

//       cl : backgroundcolor 지정하기
        String color = "yellow";

//        #rgb 혹은 지정색상(red, blue, ...)으로 지정 가능(문자열로 입력하기!)
//        String to Color 타입으로 변환
//        Color.parseColor()
        cl.setBackgroundColor(Color.parseColor(color));

        btn_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Color_Activity.class);
//                양방향 데이터 이동 : startFor쓰면 자동입력 목록 나옴
                startActivityForResult(intent, COLOR);  // 취소선은 곧 없어질 함수라는 것!
//                하지만 새로 나온 함수가 에러가 너무 많이 나서 사라지지 않을 것 같음.

//                Home_Activity를 첫 화면으로

            }
        });
    }

//        onCreate() 끝
//        부모클래스에서 만들어진 기능을 재정의 : Method Overriding
//        Android에서 오버라이딩 단축키 : Ctrl + o
//        다른 액티비티를 갔다가 원래 액티비티로 돌아올 때,
//        호출되는 메소드 중에서 intent값을 꺼낼 수 있는
//        onActivityResult() 메소드를 오버라이딩하자!

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
//        이 메소드가 호출되는 시점!!
//        다른 액티비티를 갔다가 다시 원래 액티비티로 돌아왔을 때 호출됨!!

        if (requestCode == COLOR){
            if (resultCode == RESULT_OK){
//                    intent에서 "color"키 값을 통해 data 꺼내서
//                    배경색깔을 지정!!
                String color = data.getStringExtra("color");
                cl.setBackgroundColor(Color.parseColor(color));
            }
        }
    }

}
