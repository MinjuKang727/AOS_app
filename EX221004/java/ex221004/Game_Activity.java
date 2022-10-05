package com.example.ex221004;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ex221004.databinding.ActivityGameBinding;

import java.util.Random;

public class Game_Activity extends AppCompatActivity {

    ActivityGameBinding binding;
    Random random;  // 랜덤한 숫자 뽑는 라이브러리
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        total = 0;  // 촘 입력 횟수
        random = new Random();  // 메모리에 생성!!

        int[] baseball = new int[3];  // 정답 배열 baseball

        for(int i = 0; i < 3; i++){
            baseball[i] = random.nextInt(9) + 1;  // bound : 9 -> 0~8  >> +1 >> 1~9

            for(int j = 0; j < i; j++){
                if(baseball[i] == baseball[j]){
                    i--;
                    break;
                }
            }
        }

        Log.d("야구게임", String.valueOf(baseball[0]));
        Log.d("야구게임", String.valueOf(baseball[1]));
        Log.d("야구게임", String.valueOf(baseball[2]));

        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total++;
                String etInput = binding.etInput.getText().toString();
                int[] inputs = new int[3];  // 사용자 입력 배열 inputs

                for (int i=0; i < 3; i++){
//                        만약 문자열 "324"가 입력된다면,
//                        문자열 배열 3, 2, 4
                        inputs[i] = Integer.parseInt(etInput.split("")[i]);
                }

                int s_cnt = 0;  // Strike 개수
                int b_cnt = 0;  // Ball 개수
                int o_cnt = 0;
//                스트라이크 개수 세기
                for(int i = 0; i < 3; i++){
                    if (inputs[i] == baseball[i]){
                        s_cnt++;
                    }else{
                        for(int j = 0; j < 3; j++){
                            if (inputs[i] == baseball[j]){
                                b_cnt++;
                            }
                        }
                    }
                }
                if (s_cnt + b_cnt != 3) {
                    o_cnt = 3 - s_cnt - b_cnt;
                }


                binding.tvResult.setText(s_cnt + "S" + b_cnt + "B" + o_cnt + "O");
                binding.tvRecord.setText(binding.tvRecord.getText().toString()+ binding.etInput.getText().toString() + "(" + binding.tvResult.getText().toString() + ") / ");
                binding.etInput.setText("");
                binding.tvTotal.setText("입력 횟수 : " + total + "번");

                if (s_cnt == 3){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Game_Activity.this);
                    builder.setTitle("정답!!");       // alert창 제목
                    builder.setMessage(String.valueOf(baseball[0]) + String.valueOf(baseball[1]) + String.valueOf(baseball[2]) + "\n축하드립니다!");  // alert창 내용

//                OK버튼을 눌렀을 때,
                    builder.setPositiveButton("1판 더!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });

//                CANCLE버튼을 눌렀을 때,
                    builder.setNegativeButton("종료", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });

                    builder.show();
                }
            }
        });

    }
}