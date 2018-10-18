package com.example.umasurakod.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button del;
    private Button dot;
    private Button equal;
    private TextView result;
    private TextView input;
    private double num1= Double.NaN;
    private double num2= Double.NaN;
    private char Action;
    private final char Addition = '+';
    private final char Sustraction = '-';
    private final char Multiplication = '*';
    private final char Division ='/';
    private final char Equal ='=';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ItsView();

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText().toString()+"0");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calc();
                if(!Double.isNaN(num1)){
                    Action = Addition;
                    result.setText(String.valueOf(num1) + "+");
                    input.setText(null);
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
                if(!Double.isNaN(num1)) {
                    Action = Sustraction;
                    result.setText(String.valueOf(num1) + "-");
                    input.setText(null);
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
                if(!Double.isNaN(num1)) {
                    Action = Multiplication;
                    result.setText(String.valueOf(num1) + "*");
                    input.setText(null);
                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
                if(!Double.isNaN(num1)) {
                    Action = Division;
                    result.setText(String.valueOf(num1) + "/");
                    input.setText(null);
                }
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
                Action = Equal;
                /* check for input1/result is NaN else keep the previous result */
                if(!Double.isNaN(num1)) {
                    result.setText(String.valueOf(num1));
                    input.setText(null);
                }
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().length() > 0){
                    CharSequence inputData = input.getText().toString();
                    input.setText(inputData.subSequence(0,inputData.length()-1));
                }
                else{
                    Log.i("debug", "onClick: hi");
                    num1 = Double.NaN;
                    num2 = Double.NaN;
                    input.setText(null);
                    result.setText(null);
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(input.getText().toString().length() > 0){
                CharSequence resLength =  input.getText().toString();
                char checkDot = resLength.charAt(resLength.length() - 1) ;
                if(checkDot != '.'){
                    input.setText(input.getText().toString()+".");
                }
            }
            else{
                  input.setText(".");
             }
            }
        });

    }
        private void ItsView(){
            one = (Button) findViewById(R.id.btn1);
            two = (Button) findViewById(R.id.btn2);
            three = (Button) findViewById(R.id.btn3);
            four = (Button) findViewById(R.id.btn4);
            five = (Button) findViewById(R.id.btn5);
            six = (Button) findViewById(R.id.btn6);
            seven = (Button) findViewById(R.id.btn7);
            eight = (Button) findViewById(R.id.btn8);
            nine = (Button) findViewById(R.id.btn9);
            zero = (Button) findViewById(R.id.btn0);
            add = (Button) findViewById(R.id.btnAdd);
            sub = (Button) findViewById(R.id.btnSub);
            mul = (Button) findViewById(R.id.btnMul);
            div = (Button) findViewById(R.id.btnDiv);
            del = (Button) findViewById(R.id.btnDel);
            dot = (Button) findViewById(R.id.btnDot);
            equal = (Button) findViewById(R.id.btnEqual);
            result = (TextView) findViewById(R.id.Result);
            input = (TextView) findViewById(R.id.Input);

        }

        private void calc() {
            if (!Double.isNaN(num1) ){
                try {
                    num2 = Double.parseDouble(input.getText().toString());
                }catch(NumberFormatException e) {
                    input.setText("Input2 is not valid");
                }
                switch (Action) {
                    case Addition:
                        num1 = num1 + num2;
                        break;
                    case Sustraction:
                        num1 = num1 - num2;
                        break;
                    case Multiplication:
                        num1 = num1 * num2;
                        break;
                    case Division:
                        num1 = num1 / num2;
                        break;
                    case Equal:
                        break;
                }
            }
            else {
                try {
                    num1 = Double.parseDouble(input.getText().toString());
                }catch(NumberFormatException e) {
                    result.setText("Input1 is not valid");
                }
            }
        }
}
