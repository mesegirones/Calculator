package com.example.misericordiagd.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    private String num = ""; // here is where the number is stored!
    private TextView numView;
    private String numAnt = "";
    private char oper = ' ';
   // private String point ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        numView = findViewById(R.id.numView);
        numView.setText(num);
    }


    public void onClickDigit(View view){
        Button b = (Button)view;
        //Toast.makeText(this, b.getText().toString(), Toast.LENGTH_SHORT).show();
        num += b.getText().toString();
        numView.setText(num);
    }

    public void onClickOperator(View view){
        Button b = (Button)view;
        numAnt = num;
        num = "";
        oper = b.getText().toString().charAt(0);
        numView.setText(num);
    }

    public void onClickEquals(View view) {
        double x = Double.valueOf(num);
        double xant = Double.valueOf(numAnt);

        switch (oper){
            case '+':
                num = Double.toString( xant + x);
                break;
            case '-':
                num = Double.toString( xant - x);
                break;
            case '*':
                num = Double.toString( xant * x);
                break;
            case '/':
                num = Double.toString( xant / x);
                break;
        }
        numView.setText(num);
    }

    public void onClickPoint(View view){
        Button p = (Button) view;
        String point = "";
        if(point.isEmpty()) {
            point = p.getText().toString();
            num += point;
            numView.setText(num);
        }
    }

    public void onClickC(View view) {
        num = "";
        numAnt = "";
        numView.setText(num);
    }
}
