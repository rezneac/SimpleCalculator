package com.example.hp.calculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonC, buttonPluse, buttonMinuse, buttonEquals, buttonSPref;
    ImageButton buttonCLC;
    int nr1, nr2;
    boolean add, sub,forSharedPref = false;
    final String Values = "values";
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        String UserName = getIntent().getExtras().getString("UserName");
        if (UserName != null) {
            Toast.makeText(Calculator.this, "Welcome," + UserName,
                    Toast.LENGTH_LONG).show();
        }

        final EditText editText = (EditText) findViewById(R.id.calculateEditText);
        editText.setClickable(false);
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);


        buttonCLC = (ImageButton) findViewById(R.id.btDeleteLastCrt);
        buttonC = (Button) findViewById(R.id.btDelete);
        button0 = (Button) findViewById(R.id.bt0);
        button1 = (Button) findViewById(R.id.bt1);
        button2 = (Button) findViewById(R.id.bt2);
        button3 = (Button) findViewById(R.id.bt3);
        button4 = (Button) findViewById(R.id.bt4);
        button5 = (Button) findViewById(R.id.bt5);
        button6 = (Button) findViewById(R.id.bt6);
        button7 = (Button) findViewById(R.id.bt7);
        button8 = (Button) findViewById(R.id.bt8);
        button9 = (Button) findViewById(R.id.bt9);
        buttonPluse = (Button) findViewById(R.id.PluseBt);
        buttonMinuse = (Button) findViewById(R.id.MinuseBt);
        buttonEquals = (Button) findViewById(R.id.EqualsBt);
        buttonSPref = (Button) findViewById(R.id.makeToastSharedPref);

        buttonSPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (forSharedPref = false) {
                    Toast.makeText(Calculator.this, "It emty, please calculate something", Toast.LENGTH_SHORT).show();
                } else if (forSharedPref = true) {
                    //save values
                    sharedPref = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(Values, editText.getText().toString());
                    editor.commit();
                    //load values and make toast.
                    String savedText = sharedPref.getString(Values, "");

                    Toast.makeText(Calculator.this, savedText, Toast.LENGTH_SHORT).show();
                }

            }
        });


        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nr1 = Integer.parseInt(editText.getText() + "");
                forSharedPref = true;

                if (add == true) {

                    editText.setText(nr1 + nr2 + "");
                    add = false;
                } else if (sub = true) {
                    editText.setText(nr1 - nr2 + "");
                    add = false;

                }


            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });
        buttonCLC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int length = editText.getText().length();
                if (length > 0) {
                    editText.getText().delete(length - 1, length);
                } else {

                    Toast.makeText(Calculator.this, "Area already empty",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "9");
            }
        });
        buttonPluse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nr2 = Integer.parseInt(editText.getText() + "");
                editText.setText("+");
                add = true;
            }
        });
        buttonMinuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nr2 = Integer.parseInt(editText.getText() + "");
                editText.setText("-");
                add = true;
            }
        });


    }


}
