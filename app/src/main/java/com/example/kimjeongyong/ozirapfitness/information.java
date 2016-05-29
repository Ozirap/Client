package com.example.kimjeongyong.ozirapfitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.kimjeongyong.fitnesscheck2.R;

/**
 * Created by KimJeongYong on 2016-04-05.
 */
public class information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        //계정의 이메일 주소를 받아오는 코드
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        Log.d("information_mail", email );

        Spinner gymnastic = (Spinner) findViewById(R.id.gymnastic);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.gyms_prompt, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gymnastic.setAdapter(adapter1);
        /*gymnastic.getSelectedItem(); 아이템선택*/

        Spinner Time = (Spinner) findViewById(R.id.Time);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.Times, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Time.setAdapter(adapter2);

        Spinner Often = (Spinner) findViewById(R.id.Often);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.howoftens, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Often.setAdapter(adapter3);

        Button complete = (Button)findViewById(R.id.complete);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*자료를 서버로 보내는 코드 작성*/
                Intent intent = new Intent(
                        /*getApplicationContext()*/information.this, // 현재 화면의 제어권자
                        Calendar.class); // 다음 넘어갈 클래스 지정
                try {
                    startActivity(intent); // 다음 화면으로 넘어간다
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
                finish();               // information 화면 끝
            }
        });
    }
}
