package com.example.ex220926;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Plus_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);

        TextView tv_calculator = findViewById(R.id.tv_calculator);
        TextView tv_operator = findViewById(R.id.tv_operator);
        TextView tv_cal_result = findViewById(R.id.tv_cal_result);
        EditText et_num1 = findViewById(R.id.et_num1);
        EditText et_num2 = findViewById(R.id.et_num2);
        Button btn_calculate = findViewById(R.id.btn_calculate);
        Button btn_plus = findViewById(R.id.btn_plus);
        Button btn_minus = findViewById(R.id.btn_minus);
        Button btn_x = findViewById(R.id.btn_x);
        Button btn_divide = findViewById(R.id.btn_divide);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = et_num1.getText().toString();
                int n1 = Integer.parseInt(num1);
                String num2 = et_num2.getText().toString();
                int n2 = Integer.parseInt(num2);


                String operator = tv_operator.getText().toString();

                String result = "결과";
                if (operator == "-"){
                    result = String.valueOf(n1 - n2);
                }else if(operator == "×"){
                    result = String.valueOf(n1 * n2);
                }else if(operator == "÷") {
                    result = String.valueOf((double) n1 / n2);
                }else{
                    result = String.valueOf(n1 + n2);
                }

                tv_cal_result.setText(String.valueOf(result));

//                UI/UX part : 계산 후, 입력값 reset & 이전 입력값이 hint로 남아 있음.
                et_num1.setText("");
                et_num1.setHint(num1);
                et_num2.setText("");
                et_num2.setHint(num2);
            }
        });

//      +(더하기) 버튼 눌렀을 때,
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_calculator.setText("더하기 계산기");
                tv_operator.setText("+");
                btn_calculate.setText("더하기");
            }
        });

//      -(빼기) 버튼 눌렀을 때,
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_calculator.setText("빼기 계산기");
                tv_operator.setText("-");
                btn_calculate.setText("빼기");
            }
        });

//      ×(곱하기) 버튼 눌렀을 때,
        btn_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_calculator.setText("곱하기 계산기");
                tv_operator.setText("×");
                btn_calculate.setText("곱하기");
            }
        });

//      ÷(나누기) 버튼 눌렀을 때,
        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_calculator.setText("나누기 계산기");
                tv_operator.setText("÷");
                btn_calculate.setText("나누기");
            }
        });
    }
}