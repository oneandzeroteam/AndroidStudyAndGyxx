package com.example.oyt.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {
    TextView txtName, txtAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        txtName = (TextView) findViewById(R.id.txtName);
        txtAge = (TextView) findViewById(R.id.txtAge);
        Intent intent = getIntent();
        if(intent != null){ //전달된 intent가 있으면
            Bundle data = intent.getBundleExtra("MyData"); // MyData라는 key를 가진 bundle 추출
            if(data != null){
                // 아까 key가 Age, Name이었던 데이터를 각각 꺼낸다.
                txtAge.setText("나이: " + data.getInt("Age"));
                txtName.setText("이름: " + data.getString("Name"));
            }
        }

        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(); //MainActivity로 전달할 intent 생성
                intent.putExtra("Name", txtName.getText().toString()); //intent에 Name이라는 키를 가진 값 투척
                setResult(RESULT_OK, intent); //resultcode 설정
                finish();
            }
        });
    }
}
