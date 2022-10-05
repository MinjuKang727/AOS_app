package com.example.ex221004;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ex221004.databinding.ActivityWifiBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Wifi_Activity extends AppCompatActivity {

//  자동 완성이 안될 때, 직접 입력 후, Alt+Enter로 import하자!
    ActivityWifiBinding binding;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        binding = ActivityWifiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> data = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.movie_list, data);
        binding.lvWifi.setAdapter(adapter);

//        네트워크 통신
//        Permission(권한)

//      2. RequestQueue객체 생성
        if(requestQueue == null){   // 모든 자료형은 선언만 되고 초기화되지 않았을 때, null 값을 가짐
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }


        binding.btnWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.clear();
//                String url = binding.etWifi.getText().toString();
                String date = binding.etWifi.getText().toString();
                String url2 = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=" + date;

//                [네트워크 통신 4단계]
//                0. Internet 권한 부여! (AndroidManifest.xml)
//                1. Volley 라이브러리 추가 (많은 라이브러리 중에 가장 많이 사용하는 라이브러리)
//                   (안드로이드 내장 라이브러리X >> 외부 라이브러리!)
//                   방법1) build.gradle 안에 dependencies에 라이브러리 주소를 추가
//                       build.gradle --> dependencies 안에
//                       implementation 'com.android.volley:volley:1.2.1'를 복사 붙여넣기 후, 오른쪽 상단 sync 클릭
//                   방법2) 직접 검색 후 추가
//                       File -> Project Structure -> Dependencies -> '+' 누른 후
//                       -> Library dependency
//                2. RequestQueue객체 생성
//                3. Request객체 생성 : StringRequest(method, url, listener, errorlistener)
//                listener : 성공 감지 listener / errorlistener
//                안쪽의 매개변수가 기억나지 않을 때, 정수를 콤마로 이어서 적으면 어떤 매개 변수를 넣어야 하는 지 알 수 있다.
//
                StringRequest request = new StringRequest(
                        Request.Method.GET,  // 전송 방법
                        url2,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
//                              응답 성공 시, 성공된 데이터는 response에 저장됨
//                                JSONObject(json파일);
//                                Java는 컴파일(Compile)언어
//                                Java에서 오류 종류(2가지)
//                                  - 컴파일 전에 알 수 있는 error
//                                int num = 5;
//                                int num = 10; : 변수 재선언 불가
//                                int num = "10"; : 자료형에 맞지 않는 값 선언 불가
//                                    - 컴파일 이후에 알 수 있는 error
//                                        try-catch문 사용
                                try{
                                    JSONObject jsonObject = new JSONObject(response);
                                    JSONObject jsonObject2 = jsonObject.getJSONObject("boxOfficeResult");
                                    JSONArray movies = jsonObject2.getJSONArray("dailyBoxOfficeList");
//                                    JSONObject movie = (JSONObject) movies.get(0);
//                                    String movieNm = movie.getString("movieNm");
//                                    binding.tvWifi.setText("1위 영화 : " + movieNm);
                                    for (int i = 0; i < movies.length(); i ++){
                                        JSONObject rth_movie = (JSONObject) movies.get(i);
                                        String movieNm = rth_movie.getString("movieNm");
                                        data.add("[" + (i + 1) + "위] " + movieNm);
//                                        3 + 7 // 10
//                                        "3" + "7" // "37"
//                                        3 + "7" // "37"
//                                        1 + 3 + "2" // "42"
//                                        1 + (2 + "3") // "123"
                                        adapter.notifyDataSetChanged();
                                    }

                                }catch(JSONException e){
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
//                              응답 실패 시,
                                data.add(error.toString());
                                adapter.notifyDataSetChanged();
                            }
                        }

                );

//                4. RequestQueue에 Request 추가
                requestQueue.add(request);


            }
        });

        binding.lvWifi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Wifi_Activity.this);
                builder.setTitle("영화 정보 보기");       // alert창 제목
                builder.setMessage("현재 영화의 자세한 정보를 보시겠습니까?");  // alert창 내용

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