package com.example.hp.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    EditText editText;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        editText = (EditText) findViewById(R.id.editText);
//        final String context = editText.getText().toString();
        loginBtn = (Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String equalsEmpty = editText.getText().toString();
                    if (equalsEmpty.matches("")) {
                        Toast.makeText(Welcome.this, "You did not keep your name", Toast.LENGTH_SHORT).show();
                        return;
                }
                else {
                    Intent myIntent = new Intent(Welcome.this,Calculator.class);
                    String context = editText.getText().toString();
                    myIntent.putExtra("UserName",context);
                    startActivity(myIntent);
                }


            }
        });
    }
}
