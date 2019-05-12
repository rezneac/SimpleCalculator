package com.example.hp.calculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class Calculator extends AppCompatActivity {

    Button buttonSPref, buttonEquals, buttonC, button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonPluse, buttonMinuse;
    ImageButton buttonCLC;

    final String Values = "values";
    SharedPreferences sharedPref;
    int values = 1;

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

        final String equalsEptss = editText.getText().toString();


        buttonSPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPref = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(Values, editText.getText().toString());
                editor.commit();
                //load values and make toast.
                String savedText = sharedPref.getString(Values, "");
                //save values

                if (values == 1) {
                    Toast.makeText(Calculator.this, "It emty, please calculate something", Toast.LENGTH_SHORT).show();
                } else if (values == 2) {


                    Toast.makeText(Calculator.this, savedText, Toast.LENGTH_SHORT).show();
                }

            }
        });


        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String equalsEpt = editText.getText().toString();
                if (TextUtils.isEmpty(equalsEpt)) {

                } else {
                    values = 2;
                    Expression expression = new ExpressionBuilder(equalsEpt).build();
                    double result = expression.evaluate();
                    editText.setText(Double.toString(result));
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
                // editText.setText(editText.getText() + "0");
                editText.append(button0.getText());
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                editText.setText(editText.getText() + "1");
                editText.append(button1.getText());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button2.getText());
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button3.getText());
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button4.getText());
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button5.getText());
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button6.getText());
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button7.getText());

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button8.getText());
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button9.getText());
            }
        });
        buttonPluse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String empty = editText.getText().toString();

                if (TextUtils.isEmpty(empty)) {

                } else if (empty.endsWith("+")) {

                } else {
                    editText.append(buttonPluse.getText());

                }

            }
        });
        buttonMinuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String empty = editText.getText().toString();

                if (TextUtils.isEmpty(empty)) {

                } else if (empty.endsWith("-")) {

                } else {
                    editText.append(buttonMinuse.getText());

                }
            }
        });


    }


}
