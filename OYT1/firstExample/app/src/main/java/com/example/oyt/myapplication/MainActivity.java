package com.example.oyt.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼을 눌렀을 때 화면에 보이는 텍스트를
                // 텍스트박스에 있는 텍스트로 변경하자.

                //editText의 내용을 str변수에 텍스트로 가져오고,
                String str = editText.getText().toString();
                textView.setText(str); // 그 str을 textView에 set 한다!
            }
        });

        Button btnToast = (Button) findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();

                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();

                //Toast tst = Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG);
                //tst.show();

            }
        });
    }
}
