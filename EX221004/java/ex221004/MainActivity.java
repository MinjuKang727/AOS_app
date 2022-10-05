package com.example.ex221004;

import static android.graphics.Color.rgb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.ex221004.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//    ViewBinding 사용법

//        0. 좌측에 Gradle Scripts
//          두 번째로 보이는 build.graddle 들어가서
//          android 하위에 buildFeatures{viewBinding = true} 추가 후 sync now 클릭

//        1. 전역변수 (field)에
//          Binding Class 선언!!
//          AMB라고 치면 자동완성 떠야함.
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        2. binding을 초기화
        binding = ActivityMainBinding.inflate(getLayoutInflater());

//        3. 초기화된 binding을 Java Class에서 접근할 수 있도록 연결
        setContentView(binding.getRoot());

//        viewBinding에서는 id가 무조건 cammel 표기법으로 바뀜 (처음부터 cammel 표기법으로 설정하자!)
        binding.tvHello.setText("화요일 OPEN AM 6:00 ~ PM 6:00");
        binding.tvHello.setTextSize(24);
        binding.tvHello.setTextColor(rgb(255, 150, 0));

//        Java -> Kotlin -> 반반
//        Java를 알면 좋다

//        findViewById() 메소드!!
//        안드로이드 내에 있는 xml파일을
//        inflator가 변환시켜 R패키지에 저장!!
//        그 R패키지 안에 id패키지 안쪽에 있는 값을 탐색!!

//        실제 개발에서는 "findViewById를 최소화" 하는 방향으로 개발이 진행
//        따로, 그 ID들을 저장해 놓는 Java Class 하나 생성!!
//        그 클래스로부터 참조해서 사용

//        --> ViewBinding 기법

//        new 쓰고 Ctrl+Space바 누르면 I라고 되어있는 Interface 추가
        binding.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                i -> position
//                해당 아이템이 몇 번째 인덱스(포지션)를 가지고 있는지 return
//                사과, 체리, 복숭아
//                각각의 포지션은 0, 1, 2

//                l -> Resource ID
                int[] price = {2000000, 676767, 16000};
                String fruit = adapterView.getAdapter().getItem(i).toString();
                binding.tvHello.setText(fruit + " : " + price[i] + "원");
            }
        });
//        위의 코드와 같은 의미를 lambda 표현식으로 쓰면 아래와 같음
//        binding.lv.setOnItemClickListener((av, v, i, l) -> {
//
//        });

    }
}