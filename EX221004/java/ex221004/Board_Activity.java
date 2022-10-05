package com.example.ex221004;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.ex221004.databinding.ActivityBoardBinding;

import java.util.ArrayList;

public class Board_Activity extends AppCompatActivity {
//  viewBinding 기법
//    0. Graddle 쪽 세팅 완료
//    1. binding 변수 선언 (Activity명이 Board_Activity라서 ABB 입력하면 자동완성 뜸)
    ActivityBoardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        2. binding 초기화
        binding = ActivityBoardBinding.inflate(getLayoutInflater());

//        3. binding을 부착
        setContentView(binding.getRoot());

//        AdapterView 사용법 6단계
//        1) ListView의 위치 결정 (RecyclerView를 사용, ListView는 사용X / 우리는 연습용으로 ListView 사용)
//          왜냐하면 ListView는 메모리 복잡도가 너무 높아서 메모리를 많이 잡아먹기 때문
//        2) 항목뷰(itemView)의 디자인 레이아웃(xml) 작성

//        3) 아이템 결정

//        게시글 : 문자열 (배열)
//        Java 배열의 단점 : 배열 생성 시, 크기가 고정 : 자료형 변수명 = new 자료형
//        >> 가변 배열(ArrayList) : ArrayList<사용할 자료형> 변수명 = new ArrayList<사용할 자료형>();
//           <> 제네릭 : java에서 null class를 방지하기 위해
//           안쪽에 들어갈 자료형은 반드시 Wrapper Class여야 한다.
        ArrayList<String> data = new ArrayList<String>();

        data.add("배가 고프다. 오늘 저녁은 뭘까?");
        data.add("집에 갈 때, 비 안왔으면 좋겠다.");
        data.add("올 크리스마스에는 행복할 수 있을까?");


//        4) Adapter Class 구현
//        단, 항목 디자인이 TextView라면 생략 가능!!
//        왜냐하면, TextView를 구현하는 Adapter Class가 이미 만들어져 있다.
//        이름은 StringAdapter

//        5) Adapter 생성 후, ListView에 부착 :  new는 파이썬의 init과 같은 기능
//        어뎁터에게 넘겨줘야 할 데이터 3개
//            5-1) 페이지 정보 : getApplicationContext()
//            5-2) 항목 뷰 디자인 레이아웃 : R.id.layout.board_list
//            5-3) 아이템 정보 : data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.board_list, data);
        binding.lvBoard.setAdapter(adapter);

//        6) ListView에 클릭 리스너, Action들을 추가!!

//          문제 정의
//          6-1) btnBoard 버튼을 클릭했을 때,
        binding.btnBoard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//          6-2) etBoard 안에 있는 내용을 String board에 저장!!
                String etBoard = binding.etBoard.getText().toString();

                binding.etBoard.setText("");
                binding.etBoard.setHint("대화글을 입력하세요.");
//          6-3) data에 board 추가!!
                data.add(etBoard);
//          6-4) 변경된 data를 Adapter에 반영
//                Adapter를 새로고침
                adapter.notifyDataSetChanged();
            }
        });
//                해당 item을 클릭했을 때,
        binding.lvBoard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

//                ArrayList의 메소드 중 가장 많이 사용한 4개
//                1) add(자료) 혹은 add(index번호, 자료)
//                2) get(인덱스 번호)
//                3) remove(인덱스 번호) 혹은 remove(자료) : 같은 자료가 여러개여도 다 삭제
//                4) clear() : 전부 삭제

//              사용자가 정말 삭제할 건지 물어보는 AlertDialog 구현
                AlertDialog.Builder builder = new AlertDialog.Builder(Board_Activity.this);
                builder.setTitle("클릭한 대화글 삭제");       // alert창 제목
                builder.setMessage("정말 삭제하시겠습니까?");  // alert창 내용

//                OK버튼을 눌렀을 때,
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//              그 item을 삭제!!
//              클릭한 item 인덱스 : position
                        data.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });

//                CANCLE버튼을 눌렀을 때,
                builder.setNegativeButton("CANCLE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });
    }
}