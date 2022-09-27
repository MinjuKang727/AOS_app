package com.example.ex220926;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam03);

        System.out.println("Hello World");

//        안드로이드 상에서 출력할 때,
//        1) System.out.println("출력 문구");  (문자열은 무조건 ""(큰 따옴표)로 작성)
//        2) Log를 통해 띄우기 : java는 자동으로  import(불러오기) 가능( 직접 입력 시, Alt+Enter로 import 가능)


//        Log. d(debug), v(verbose), e(Error), i(Info), w(Warn), A(Assert)
        Log.d("출력","Hello World");
//        맨 아래 Logcat 에서 돋보기에 태그 값 입력하면 확인 가능

//        Java란?
//        '제임스 고슬링'이 개발
//        Java섬?? 인도네시아의 섬 >> 개발자가 Java섬 커피를 좋아했다는 설이 있음 . 로고도 커피 로고

//        5라는 정수형 data를 num이라는 변수에 넣자!
        int num = 5;

// java의 기본 자료형
// boolean : 논리형
// char : 문자형
// byte, short, int, long : 정수형 (정수는 int 정도만)
// float, double : 실수형   (실수는 double 정도만 알면 됨)


//      이건 자료형이 나온 김에 그냥 해보는 부동 소수점 예시 >> 정확한 소수로 표현해주는 함수나 메서드를 사용해야 함
        double num1 = 1.1;
        double num2 = 2.2;
//        String.valueOf(변환하고자 하는 값)
        Log.d("출력", String.valueOf(num1 + num2)); // 출력은 문자열만 가능 : String.valueOf()로 문자열로 값을 가져오자!
//        부동 소수점  3.3000000000000003


//        Java에서 기본 자료형(8가지)가 아니다 >> 무조건 Reference Type
//        Reference Type의 3가지 용도
//        1) "배열"에 대한 래퍼런스
//        2) "클래스"에 대한 래퍼런스
//        3) "인터페이스"에 대한 래퍼런스


        boolean check = true;     //소문자 true!!
        boolean check2 = false;   // 소문자 false!!

        char char1 = 'A';
        String name = "나예호";  // String도 래퍼런스 타입!! ( 1.1버전 부터 사용가능한 자료형)

        byte b1 = -128;
        byte b2 = 127;      // byte는 -128~127까지만 대입 가능
//        byte b3 = -129;   // Error!! : -129는 int!!
//        int  n3 = 128;
//        byte b3 = (byte) n3;
//        형변환을 해서 넣으면 입력값 범위를 초과하더라도 들어감
//        But!!  Overflow or Underflow 됨
//        b3 : -128
//        단, 형변환 전의 값은 분명하게 정의되어 있어야 함
//        long l3 = (long)2300000000;는 불가 왜냐하면 정수는 기본적으로 int로 보는데 int로 선언 불가한 값 범위!

        short s1 = -32768;  // up-down은 이진탐색!!
        short s2 = 32767;

        int n1 = 50000;

//        Java의 정수 기본 타입은 int
//        Java의 실수 기본 타입은 double
//        int n2 = 2300000000;  //  int 크기를 넘어간 숫자 Error!! >> long 타입으로 선언해 보자!
//        long l0  = 2300000000;  // Error?  : 정수는 기본적으로 int라고 보기 때문에 error 발생
        long l1 = 2300000000l; // 혹은 long l1 = 2300000000L;

//        float은 4byte / double은 8byte
//        float f1 = 2.3;  Error!!
        float f1 = (float) 2.3;  // double형 2.3을 (float)로 형변환
        float f2 = 2.3f;
        float f3 = 2.3F;

        double d1 = 2.3;

//        정수형 데이터 5개를 넣는 공간
//        Java에서 Reference 타입 여부를 확인하는 이유

        int[] array;  //배열(에 대한 래퍼런스)의 선언
        array = new int[5];  // 배열의 생성 : 래퍼런스 타입은 new로 생성해 줌  : 그럼 String은??? (생략된 것!)

        int[] array2 = new int[5];

        array[0] = 3;
        array[1] = 5;
        array[2] = 7;
        array[3] = 9;
        array[4] = 11;

        Log.d("출력", String.valueOf(array));  //[I@29eba3e
//        기본 자료형은 메모리에 값을 : call by value
//        래퍼런스 값은 주소로 되어 있음 : call by reference (reference는 '참조하다'는 뜻)
//        래퍼런스 값은 String.valueOf()로 저장된 값을 볼 수 없음 >> 인덱스로 값을 가져와야 함
        
        
//        Java 배열의 특징
//        1) 생성(new) 시, 반드시 크기가 지정되어야 함.
//          String[] drinks = new String[]; : Error!
//        2) 생성과 동시에 초기화 시에는 크기 지정 필요X & new String 생략 가능
        String[] drinks2 = new String[]{"아침햇살", "포카리스웨트", "코코팜"};
        String[] drinks3 = {"아침햇살", "포카리스웨트", "코코팜"};
        
//        String의 생성은 new 생략 가능
        String my = "강민주";
        
        String[] snacks = {"뿌셔뿌셔불고기맛", "스윙칩"};
        
        Log.d("출력2",  drinks2[0]);  // 아침햇살
        Log.d("출력2",  snacks[0]);   // 뿌셔뿌셔불고기맛

        drinks2 = snacks;
//      drinks2 래퍼런스에 저장된 주소값이 snacks의 주소로 바뀜
//      {"아침햇살", "포카리스웨트", "코코팜"}은 주소가 어디인지 알 수 없게됨...
//      garbage collecter가 모아서 정리(삭제)함.

        Log.d("출력3", drinks2[0]); // 뿌셔뿌셔불고기맛
        Log.d("출력3", snacks[0]);  // 뿌셔뿌셔불고기맛

        snacks[0] = "썬칩";
        Log.d("출력4", snacks[0]);   // 썬칩
        Log.d("출력4", drinks2[0]);  // 썬칩
//      drinks2에 저장된 주소가 snacks로 바뀌었기 때문에
//      snacks의 주소에 저장된 값들의 변경시, drinks의 인덱스 값도 snacks의 인덱스 값과 같게 나옴

    }
}