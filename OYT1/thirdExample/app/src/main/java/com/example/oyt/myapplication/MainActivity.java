package com.example.oyt.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editName, editAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = (EditText) findViewById(R.id.txtName);
        editAge = (EditText) findViewById(R.id.editAge);
        Button btnShow = (Button) findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                int age = Integer.parseInt(editAge.getText().toString());  // editAge에서 정수를 뽑아낸다.
                Intent intent = new Intent(getApplicationContext(), MyActivity.class);//MyActivity를 띄우는 intent 정의
                Bundle bundle = new Bundle(); //이름과 나이 정보를 넣을 bundle 객체 정의
                bundle.putInt("Age", age); //bundle에 Age라는 key로 age 값 투입
                bundle.putString("Name", name); //bundle에 Name이라는 key로 name 값 투입
                intent.putExtra("MyData", bundle); //intent에 MyData라는 key를 가진 bundle 투입
                startActivity(intent); //intent를 시스템에 전달 -> 새로운 액티비티가 뜬다.
            }
        });
    }
}
