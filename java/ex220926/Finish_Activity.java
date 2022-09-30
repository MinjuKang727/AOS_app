package com.example.ex220926;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Finish_Activity extends AppCompatActivity {

    Button btn_start;
    TextView tv_end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        btn_start = findViewById(R.id.btn_start);
        tv_end = findViewById(R.id.tv_end);


//      intent에서 데이터를 꺼내자!!
        String menu = getIntent().getStringExtra("menu");
        tv_end.setText(menu);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Finish_Activity.this, Start_Activity.class);
                startActivity(intent);
//                그런데 이렇게 하면 처음 >> 끝 >> 처음 화면으로 갔다가 취소를 누르면
//                앱이 종료되지 않고 현재 화면 실행 전의 화면(끝)이 나옴

//                현재 보여지는 Activity를 종료
//                finish();
            }
        });

    }
}