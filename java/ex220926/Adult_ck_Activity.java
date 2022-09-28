package com.example.ex220926;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Adult_ck_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adult_ck);




//        Activity를 새로 만들었다면
//        반드시 확인해야할 부분
//        첫 시작 화면을 어떤 화면으로 설정할 건지
//        좌측 manifests 폴더 안에 AndroidManifest.xml에서 intent-filter 태그로 설정
//        intent-filter : 첫번째로 시작할 엑티비티를 결정해 주는 태그
//        반드시 Activity 태그 바로 뒤에 넣어 주어야 함.(다른 태그 안에 넣으면 오류 발생!)
//        intent-filter는 모든 Activity태그 중 한 곳에만 둘 수 있으며
//        Activity 태그 안에 exported="true"로 설정해 주어야 함.
//        나머지 Activity는 exported="false"로 설정하면 메모리를 절약할 수 있지만 안해도 됨
//        ※ 모든 Activity와 모든 xml파일에서 오류가 없어야 에뮬레이터가 실행 됨


//        문제 정의
//        0. 사용할 모든 View를 초기화!!
//        (자동완성으로 입력하자! >> 그래야 자동 import 됨)

        TextView tv_qna = findViewById(R.id.tv_qna);
        EditText et_input = findViewById(R.id.et_input);
        Button btn_confirm = findViewById(R.id.btn_confirm);

//        String str1 = tv_qna.getText().toString();
//        str1 += "Hello";
//
//        tv_qna.setText(str1); // TextView 문구 설정


//       cf. TextView : 래퍼런스 타입!
//        처음 가져오면 View 타입 >> TextView로 다운캐스팅 해주어야 하지만 자동으로 됨
//        TextView tv_qna = (TextView) findViewById(R.id.tv_qna); : 다운 캐스팅

//        1. btn_confirm을 눌렀을 때,
//        1-1. 버튼 클릭을 감지하는 리스너 설치!!
//        여러가지 행동들이 일으키는 사건 : Event
//        이벤트(onClick, hover, ...)를 감지하는 객체 : Listenner

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                1-2. btn_confirm을 눌렀을 때,
//        2. et_input의 값을 가져온 후,
                String input = et_input.getText().toString();
//                String to Int 변환 : Integer.parseInt(문자열)
                int age = Integer.parseInt(input);

//        3. 20이상이면 tv_qna를 "성인입니다."로 수정
                if (age >= 20){
                    tv_qna.setText("성인입니다.");
                }else{
//        3. 20미만이면 tv_qna를 "미성년자입니다."로 수정
                    tv_qna.setText("미성년자입니다.");
                }

            }
        });









    }
}