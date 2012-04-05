package com.imjeee.BasicCalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class BasicCalculatorActivity extends Activity {

    TextView solution;
    EditText toCalculate;

    private int[] buttons = {R.id.Sin, R.id.Cos, R.id.Tan, R.id.Sqrt, 
                             R.id.Number7, R.id.Number8, R.id.Number9, R.id.Plus,
                             R.id.Number4, R.id.Number5, R.id.Number6, R.id.Minus,
                             R.id.Number1, R.id.Number2, R.id.Number3, R.id.Multiply,
                             R.id.Number0, R.id.Dot, R.id.Pi, R.id.Divide};

    private int[] specialButtons = {R.id.Equal, R.id.Clear, R.id.Space, R.id.Pi};

    /** Called when the activity is first created. */
    @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        initScreenButtons();
        initSpecialButton();
        initToCalculate();

    }

    private void initToCalculate(){
        toCalculate = (EditText) findViewById(R.id.ToCalculate);
        solution = (EditText) findViewById(R.id.Solution);
    }

    private void initSpecialButton(){
        for (int i : specialButtons){
            final Button btn = (Button) findViewById(i);
            btn.setOnClickListener(new OnClickListener() {
                    public void onClick(View v){
                        String btnString = btn.getText().toString();
                        if (btnString.equals("=")){
                            double result = Rpn.solve(toCalculate.getText().toString());
                            solution.setText(Double.toString(result));
                        } else if (btnString.equals("Space")){
                            toCalculate.append(" ");
                        } else if (btnString.equals("C")){
                            toCalculate.setText("");
                        } else if (btnString.equals("¹")){
                            toCalculate.append(" 3.14 ");
                        } else {
                            System.out.println("error");
                        }
                    }         
                });}
        }


    private void initScreenButtons(){
        for (int i : buttons){
            final Button btn = (Button) findViewById(i);
            btn.setOnClickListener(new OnClickListener() {
                    public void onClick(View v){
                      toCalculate.append(btn.getText().toString());
                    }         
                });
        }
    }
}